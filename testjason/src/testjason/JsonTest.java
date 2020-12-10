package testjason;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.net.HttpURLConnection;
//import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
//import java.nio.file.Files;
//import java.nio.file.Paths;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class JsonTest {

	public static void main(String[] args) {
		String city = "Montegiorgio";
		String APIKey = "19424eeea64914627b18e861c3ae0688";
		String url = "https://api.openweathermap.org/data/2.5/weather?q="+ city +"&appid=" + APIKey;
		try {
		URLConnection connection = new URL(url).openConnection();
		connection.setDoOutput(true);
		InputStream in = connection.getInputStream();
		
		String ris= "";
		String line="";
		try {
		InputStreamReader normal = new InputStreamReader(in);
		BufferedReader buffer = new BufferedReader(normal);
		
		while((line=buffer.readLine()) != null) {
			ris +=line ;
		}
		}finally {
			in.close();
		}
		
		JSONObject obj =(JSONObject) JSONValue.parseWithException(ris);
		String macro_object= "";
		macro_object= "{\"visibility\":" +(obj.get("visibility").toString());
		macro_object = macro_object.concat(",\"base\":\"" +(obj.get("base").toString())+"\"");
		macro_object = macro_object.concat(",\"dt\":" +(obj.get("dt").toString()));
		macro_object = macro_object.concat(",\"timezone\":" +(obj.get("timezone").toString()));
		macro_object = macro_object.concat(",\"id\":" +(obj.get("id").toString()));
		macro_object = macro_object.concat(",\"name\":\"" +(obj.get("name").toString())+"\"");
		macro_object = macro_object.concat(",\"cod:\"" +(obj.get("cod").toString())+"}");
		JSONObject macro_obj =(JSONObject) JSONValue.parseWithException(macro_object);
		
		JSONArray a= new JSONArray();
		a.add(macro_obj);
		a.add(obj.get("coord"));
		a.add(obj.get("main"));
		a.add(obj.get("wind"));
		a.add(obj.get("clouds"));
		a.add(obj.get("sys"));
		try {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("JSONMeteo.txt", true)));
		out.println(a);
		out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		out.println();
		out.close();
		}catch(IOException e) {
			System.out.println(e);
		}
		
		System.out.print("ok");
		
		
		}catch(IOException | ParseException e ) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}		
}
