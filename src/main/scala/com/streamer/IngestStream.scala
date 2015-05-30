package com.streamer

import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

import javax.net.ssl.HttpsURLConnection;

object IngestStream {
  
  val userAgent = "Mozilla/5.0";
  val url = "http://stream.meetup.com/2/rsvps"
  
  def sendGet() = {
    val obj = new URL(url)
    val con = obj.openConnection().asInstanceOf[HttpURLConnection]
    
    con.setRequestMethod("GET");
    
    con.setRequestProperty("User-Agent", userAgent)
    
    val responseCode = con.getResponseCode
    
    val in =  new BufferedReader(
            new InputStreamReader(con.getInputStream()))
    
    while(true){
      val inputLine = in.readLine()
      println(inputLine)
    }
  }
  
  def main(args: Array[String]): Unit = {
    println("hello")
    sendGet()
  }
}