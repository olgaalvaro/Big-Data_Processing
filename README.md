# Big-Data_Processing

### Kafka Streaming

1. Crear el topic topicpractica

Accedemos como root a la terminal y en la ruta /home/kafka/kafka_2.11-2.4.0/bin ejecutamos los siguientes comandos:

- Listar los topics, como no hay ninguno procedemos a crearlo
  ./kafka-topics.sh --list --zookeeper localhost:2181
- Crear el topic topicpractica
  /kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic topicpractica
- Verificamos   


### Parte de investigación

1. Instalación de Zeppelin 

   https://colab.research.google.com/drive/1Xgu4txFgjnN8jtsrkFoNNo9zmTQy0hSJ

2. Configuración Spark para conectar Apache Spark y Apache Zeppelin

   https://colab.research.google.com/drive/1difR0LWtHnIaVZuIKw8EmAKe4FHgzXZd

3. Trabajar con el fichero amigos.csv para calcular el nº de registros desde:

   - IntelliJ IDEA https://colab.research.google.com/drive/1N9I93UshWu4VOhH4V4RM0kU60dJeumgT
   
   - Zeppelin      https://colab.research.google.com/drive/1rBYE2ygimIfoqay8wxRwHthiXLMozobL


