package generateAnnotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class generateGeoData {
	public static void main(String[] args){
	generateGeoData obj=new generateGeoData();
	File metaDataQuad=new File("metaData.quad");
	File geoDataQuad=new File("geoData.quad");
	
	BufferedReader reader=null;
	List<String> list = new ArrayList<String>();
	try{
		reader=new BufferedReader(new FileReader(metaDataQuad));
		String tempString=null;
		while((tempString=reader.readLine())!=null){
				list.add(tempString);
			}
		FileWriter geoDataQuadWriter=new FileWriter(geoDataQuad.getName(),true);
		BufferedWriter geoQuadBuffer=new BufferedWriter(geoDataQuadWriter);
		int length=list.size();
		String temp1,temp2,temp3,temp4,temp5,temp6;
		long random1,random2,random3;
		double lon,lat;//随机产生经纬度以及ID
		String LON,LAT;
		DecimalFormat  df = new DecimalFormat("######0.0000");   
		for(int i=0;i<length;i++){
			temp1=list.get(i);
			temp2=temp1.substring(temp1.indexOf("<"), temp1.indexOf(">")+1);//取出s

			//生成纬度随机ID
			random1=obj.randomDataGenerater(10000, 99999);
			random2=obj.randomDataGenerater(10000, 99999);
			random3=obj.randomDataGenerater(1000, 9999);//
			temp3="<http://yago-knowledge.org/resource/id_"+random1+"_"+random2+"_"+random3+">";//Start锟斤拷ID
			
			//生成经度随机ID
			random1=obj.randomDataGenerater(10000, 99999);
			random2=obj.randomDataGenerater(10000, 99999);
			random3=obj.randomDataGenerater(1000, 9999);//
			temp4="<http://yago-knowledge.org/resource/id_"+random1+"_"+random2+"_"+random3+">";//Start锟斤拷ID
			
			//生成随机经纬度
			lon=obj.randomFloatDataGenerater(-180.0, 180.0);
			LON=df.format(lon);
			temp5=" <http://www.w3.org/2003/01/geo/wgs84_pos#long> ";//经度
			lat=obj.randomFloatDataGenerater(-90.0, 90.0);
			LAT=df.format(lat);
			temp6=" <http://www.w3.org/2003/01/geo/wgs84_pos#lat> ";//纬度
			geoQuadBuffer.write(temp2+temp5+"\""+LON+"\"^^"+"<http://www.w3.org/2001/XMLSchema#float> "+temp3+".\n");
			geoQuadBuffer.write(temp2+temp6+"\""+LAT+"\"^^"+"<http://www.w3.org/2001/XMLSchema#float> "+temp4+".\n");
		}
		geoQuadBuffer.close();
	}catch(IOException e){
		e.printStackTrace();
	}
	}
	
	//生成随机数
	public long randomDataGenerater(long min,long max){
		long temp;
		temp=(long)(Math.random()*(max-min))+min;
		return temp;
	}

	//生成随机浮点数
	public double randomFloatDataGenerater(double min,double max){
		double temp;
		temp=(double)(Math.random()*(max-min))+min;
		return temp;
	}
}
