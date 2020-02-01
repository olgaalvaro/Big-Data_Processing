import org.apache.spark.sql.SparkSession
case class Amigo (ID:Int, nombre:String, edad:Int, namigos:Int)

object csvamigos_case {

  def main(args: Array[String]): Unit = {

    // Conexión a Spark con SparkSession requerido en  Spark SQL
    val spark: SparkSession = SparkSession.builder().master("local").appName("appFichero").getOrCreate()

    // RDD Lectura del fichero amigos.csv
    // Transformación del fichero para procesar cada fila según la clase Amigo
    val datos = spark.sparkContext.textFile("amigos.csv").map(_.split(","))
      .map(atributos => Amigo(atributos(0).toInt, atributos(1), atributos(2).toInt, atributos(3).toInt))

    datos.collect().foreach(println)

    import spark.implicits._
    // Dataset
    val schemacsv = datos.toDF
    schemacsv.printSchema()

    // Crear la vista temporal
    schemacsv.createOrReplaceTempView("amigos")

    // Consulta SQL
    val nregistros = spark.sql("select count(*) from amigos")
    println("NÚMERO TOTAL DE REGISTROS ")
    nregistros.show()

  }

}
