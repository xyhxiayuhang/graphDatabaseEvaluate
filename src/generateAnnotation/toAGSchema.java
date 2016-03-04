package generateAnnotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class toAGSchema {
	public static void main(String[] args){
	toAGSchema obj=new toAGSchema();
	File metaDataQuad=new File("import/metaData.quad");
	File AGmetaDataQuad=new File("import/AGmetaData.quad");
	
	BufferedReader reader=null;
	List<String> list = new ArrayList<String>();
	try{
		reader=new BufferedReader(new FileReader(metaDataQuad));
		String tempString=null;
		while((tempString=reader.readLine())!=null){
				list.add(tempString);
			}
		FileWriter metaDataQuadWriter=new FileWriter(AGmetaDataQuad.getName(),true);
		BufferedWriter metaQuadBuffer=new BufferedWriter(metaDataQuadWriter);
		int length=list.size();
		String temp1,temp2,temp3,temp4,temp5,temp6,temp7,temp8,temp9,temp10,temp11;
		long random1,random2,random3;//�������ID
		Date randomDate =null;
		Date randomDate2=null;
		String dateString=null;
		String dateString2=null;
		for(int i=0;i<length;i++){
			temp1=list.get(i);
			temp2=temp1.substring(temp1.lastIndexOf("<"), temp1.lastIndexOf(">")+1);//ȡ��g ����g
			temp3=temp1.substring(0, temp1.lastIndexOf("<")-1);//ȡ��s p o
			temp4=temp3.substring(1, temp3.indexOf(">"));//ȡ��s
			temp5=temp3.substring(0, temp3.indexOf("\"")-1);//ȡ��s p

			//�������ID
			random1=obj.randomDataGenerater(10000, 99999);
			random2=obj.randomDataGenerater(10000, 99999);
			random3=obj.randomDataGenerater(1000, 9999);//����annotated��ID
			temp6="<http://yago-knowledge.org/resource/id_"+random1+"_"+random2+"_"+random3+">";//Start��ID
			
			random1=obj.randomDataGenerater(10000, 99999);
			random2=obj.randomDataGenerater(10000, 99999);
			random3=obj.randomDataGenerater(1000, 9999);//����annotated��ID
			temp9="<http://yago-knowledge.org/resource/id_"+random1+"_"+random2+"_"+random3+">";//End��ID
			
			random1=obj.randomDataGenerater(10000, 99999);
			random2=obj.randomDataGenerater(10000, 99999);
			random3=obj.randomDataGenerater(1000, 9999);//����annotated��ID
			temp10="<http://yago-knowledge.org/resource/id_"+random1+"_"+random2+"_"+random3+">";//StartPoint��ID
			
			random1=obj.randomDataGenerater(10000, 99999);
			random2=obj.randomDataGenerater(10000, 99999);
			random3=obj.randomDataGenerater(1000, 9999);//����annotated��ID
			temp11="<http://yago-knowledge.org/resource/id_"+random1+"_"+random2+"_"+random3+">";//Endpoint��ID
			
			//�����������
			randomDate=randomDate("2012-06-01T00:00:00.235-0700", "2015-12-30T00:00:00.235-0700");//����ʱ���ʽΪ2014-06-12T00:12:00
			dateString=String.format("%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS", randomDate);//������תΪ�ַ�����ʽ��ȡ�̸�ʽ
			dateString2=dateString+".235-0700";
			randomDate2=randomDate(dateString2,"2015-12-31T00:00:00.235-0700");
			dateString2=String.format("%1$tY-%1$tm-%1$tdT%1$tH:%1$tM:%1$tS", randomDate2);
			temp7="\""+dateString+"\""+"^^<http://www.w3.org/2001/XMLSchema#dateTime>";//Start��O
			temp8="\""+dateString2+"\""+"^^<http://www.w3.org/2001/XMLSchema#dateTime>";//End��O
			
			metaQuadBuffer.write(temp5+" "+"<"+temp4+"Start> "+temp2+".\n");
			metaQuadBuffer.write("<"+temp4+"Start>"+" "+"<http://franz.com/ns/allegrograph/3.0/temporal/time> "+temp7+" "+temp6+".\n");
			metaQuadBuffer.write("<"+temp4+"End>"+" "+"<http://franz.com/ns/allegrograph/3.0/temporal/time> "+temp8+" "+temp9+".\n");
			metaQuadBuffer.write("<"+temp4+">"+" "+"<http://franz.com/ns/allegrograph/3.0/temporal/startpoint> "+"<"+temp4+"Start>"+" "+temp10+".\n");
			metaQuadBuffer.write("<"+temp4+">"+" "+"<http://franz.com/ns/allegrograph/3.0/temporal/endpoint> "+"<"+temp4+"End>"+" "+temp11+".\n");
			i++;
		}
		metaQuadBuffer.close();
	}catch(IOException e){
		e.printStackTrace();
	}
	}
	
	//�������ID
	public long randomDataGenerater(long min,long max){
		long temp;
		temp=(long)(Math.random()*(max-min))+min;
		return temp;
	}
	
	//�������ʱ��
    private static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            Date start = format.parse(beginDate);// ��ʼ����
            Date end = format.parse(endDate);// ��������
            
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














