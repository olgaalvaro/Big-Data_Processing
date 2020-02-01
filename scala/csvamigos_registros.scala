import org.apache.spark.sql.SparkSession

object csvamigos_registros {

  def main(args: Array[String]): Unit = {

    // Conexión a Spark con SparkSession requerido en  Spark SQL
    val spark: SparkSession = SparkSession.builder().master("local").appName("appFichero").getOrCreate()

    // DATAFRAME con la carga del fichero amigos.csv (sin cabecera) en modo programática read.format
    val df = spark.read.format("csv").option("delimiter", ",").load("amigos.csv")

    // Convertir el fichero csv en una tabla
    df.createOrReplaceTempView("amigos")
    val dfsql = spark.sql("select count(*) from amigos")
    println("NÚMERO TOTAL DE REGISTROS ")
    dfsql.show()

    // Cerrar conexión
    spark.stop()

  }
}

