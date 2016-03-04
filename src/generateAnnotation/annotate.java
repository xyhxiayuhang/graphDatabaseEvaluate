package generateAnnotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class annotate {
	public static void main(String[] args){
		annotate obj=new annotate();
		File file=new File("dataTest.nt");
		File annotated=new File("annotated.nt");
		File metaData=new File("metaData.nt");
		BufferedReader reader=null;
		List<String> list = new ArrayList<String>();
		try{
			reader=new BufferedReader(new FileReader(file));
			String tempString=null;
			while((tempString=reader.readLine())!=null){
					list.add(tempString);
				}
			FileWriter fileWriter=new FileWriter(annotated.getName(),true);
			FileWriter writer=new FileWriter(metaData.getName(),true);
			BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
			BufferedWriter bufferedWriter2=new BufferedWriter(writer);
			int length=list.size();
			String temp,temp1,temp2,temp3,temp4;
			long random1,random2,random3;//生成随机ID
			long random4,random5,random6;//生成metaData的随机ID，occur_since
			Date randomDate =null;
			String dateString=null;
			for(int i=0;i<length;i++){
				random1=obj.randomDataGenerater(10000, 99999);
				random2=obj.randomDataGenerater(10000, 99999);
				random3=obj.randomDataGenerater(1000, 9999);//生成annotated的ID
				
				random4=obj.randomDataGenerater(10000, 99999);
				random5=obj.randomDataGenerater(10000, 99999);
				random6=obj.randomDataGenerater(1000, 9999);//生成metaData的ID,occur_since
				
				randomDate=randomDate("2012-06-01", "2015-12-12");
				dateString=String.format("%tF", randomDate);//将日期转为字符串格式，取短格式
				
				temp="#@ <http://yago-knowledge.org/resource/id_"+random1+"_"+random2+"_"+random3+">"+"\n";
				temp1="\""+dateString+"\""+"^^<http://www.w3.org/2001/XMLSchema#date>."+"\n";
				temp2="<http://yago-knowledge.org/resource/occursSince>";
				temp3="<http://yago-knowledge.org/resource/id_"+random1+"_"+random2+"_"+random3+">";
				temp4="#@ <http://yago-knowledge.org/resource/id_"+random4+"_"+random5+"_"+random6+">"+"\n";
				bufferedWriter.write(temp+list.get(i)+"\n");
				bufferedWriter2.write(temp4+temp3+" "+temp2+" "+temp1);
			}
			bufferedWriter.close();
			bufferedWriter2.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	//生成随机ID
	public long randomDataGenerater(long min,long max){
		long temp;
		temp=(long)(Math.random()*(max-min))+min;
		return temp;
	}
	
	//生成随机时间
    private static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);// 开始日期
            Date end = format.parse(endDate);// 结束日期
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());
            
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    private static long random(long begin, long end) {
        long rtnn = begin + (long) (Math.random() * (end - begin));
        if (rtnn == begin || rtnn == end) {
            return random(begin, end);
        }
        return rtnn;
    }
}
