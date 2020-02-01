import org.apache.spark.sql.SparkSession

object csvamigos_contar {

  def main(args: Array[String]): Unit = {

    // Conexión a Spark con SparkSession requerido en  Spark SQL
    val spark = SparkSession.builder().master("local").appName("calcularcsv").getOrCreate()

    // DATAFRAME con la carga del fichero amigos.csv (sin cabecera) en modo programática read.format
    val df = spark.read.format("csv").option("delimiter", ",").load("amigos.csv")
    df.show()

    // Schemas (tipos de datos)
    df.printSchema()

    // Estructura SQL para el cálculo del nº de registros
    val df1=spark.sql("select count(*) from csv.`amigos.csv`")
    println("NÚMERO TOTAL DE REGISTROS ")
    df1.show()

    // Cerrar conexión
    spark.stop()

  }
}
