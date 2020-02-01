import org.apache.spark.{SparkConf, SparkContext}

object csvamigos_palabras {

  def main(args: Array[String]): Unit = {

    // Conexión a Spark con SparkContext
    val conf = new SparkConf().setAppName("csvpalabras").setMaster("local") //SparkConf()
    val sc = new SparkContext(conf)

    // RDD Lectura del fichero amigos.csv guardado en la ruta del proyecto /home/keepcoding/IdeaProjects/TestScalaNuevo
    val input = sc.textFile("amigos.csv")

    // Transformación para obtener en cada línea del RDD las palabras que están separadas por ,
    // para despues inicializar el conteo por cada palabra
    val palabras = input.flatMap(linea => linea.split(",")).map(pal=> (pal,1))
    println("El número total de palabras en el csv es: " + palabras.count())

    // Obtener el par (palabra, nº de veces que se repite)
    val totalpalabras = palabras.countByValue()
    totalpalabras.foreach(println)

  }
}
