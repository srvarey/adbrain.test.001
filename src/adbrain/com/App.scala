package adbrain.com

import java.io.File
import java.text.SimpleDateFormat


import org.joda.time.DateTime

import scala.io.Source
import com.github.nscala_time.time.Imports._
import com.datastax.driver.core.Cluster
import scala.concurrent.Await
import scala.concurrent.duration._

import com.datastax.spark.connector._

import org.apache.spark.{Logging, SparkContext, SparkConf}


import java.nio.ByteBuffer

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.Map

import org.apache.cassandra.hadoop.ConfigHelper
import org.apache.cassandra.hadoop.cql3.CqlPagingInputFormat
import org.apache.cassandra.hadoop.cql3.CqlConfigHelper
import org.apache.cassandra.hadoop.cql3.CqlOutputFormat
import org.apache.cassandra.utils.ByteBufferUtil
import org.apache.hadoop.mapreduce.Job

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._


/*
cassandra table climate = cycling.climate (location text, obsdate timestamp, tmin int, tmax int, primary key(location, text)

Note to reviewer!! Dont like using string in key
Better way to have a lookup table with string , int pairs and using location id
Note enough time to do full solution

 */


case class Climate(
                      location: String,
                      obsdate: DateTime,
                      tmin: Int,
                      tmax: Int
                      )


object TestPart01 {


    def doAnalytics: Unit = {

        //Use KernelDensity and RunRisk as templates
    }

    var sc : SparkContext = null


    def init: Unit = {
        val conf = new SparkConf(true)
          .set("spark.cassandra.connection.host", "maverick001")
          //.setMaster("spark://maverick001:7077")
          .setMaster("local")

        //  val sc = new SparkContext("spark://maverick001:7077", "test", conf)
        sc = new SparkContext("local", "test", conf)
    }


    def main(args: Array[String]): Unit = {

        init

        readClimateInsert("./")

        doAnalytics
    }





    def readClimateInsert(prefix: String): Unit = {


        val factorsPrefix = prefix + "data/climate/"

        val factors1 = Array("w.csv").  //w.csv just a small file for testing
            map(x => new File(factorsPrefix + x)).
            map(readClimateHistory)
    }



    def readClimateHistory(file: File): Unit = {
        val format = new SimpleDateFormat("yyyymmdd")
        val lines = Source.fromFile(file).getLines().toSeq

        for (line <- Source.fromFile(file).getLines()) {

            val cols = line.split(';')

            val location = cols(0).toString
            val date = new DateTime(format.parse(cols(1)))
            val attr = cols(2)

            if (attr == "TMAX") {

                //Do initial insert
                val value = cols(3).toInt

                println("%s\t%s\t%s\t%d".format(location, date, attr, value))

                val collection = sc.parallelize(Seq((location, date, attr, value)))

                collection.saveToCassandra("cycling", "climate", SomeColumns("location", "obsdate", "tmin", "tmax"))

            }
            if (attr == "TMIN") {

                //Update matching TMAX record

                //Have to do this because climate data not all on one row
                //Attributes on unique rows
                //Could format input file

                //TODO collection.update where select from climate where location = location and date = date, set tmin

            }

        }
    }
}
