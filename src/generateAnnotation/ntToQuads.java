package generateAnnotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ntToQuads {
	public static void main(String[] args){
	File annotatedNt=new File("annotated.nt");
	File annotatedQuad=new File("annotated.quad");
	
	BufferedReader reader=null;
	List<String> list = new ArrayList<String>();
	try{
		reader=new BufferedReader(new FileReader(annotatedNt));
		String tempString=null;
		while((tempString=reader.readLine())!=null){
				list.add(tempString);
			}
		FileWriter annotatedQuadWriter=new FileWriter(annotatedQuad.getName(),true);
		BufferedWriter annoQuadBuffer=new BufferedWriter(annotatedQuadWriter);
		int length=list.size();
		String temp1,temp2;
		for(int i=0;i<length;i++){
			temp1=list.get(i);
			temp1=temp1.substring(3, temp1.length());
			temp2=list.get(i+1);
			temp2=temp2.substring(0, temp2.length()-1);
			annoQuadBuffer.write(temp2+" "+temp1+".\n");
			i++;
		}
		annoQuadBuffer.close();
	}catch(IOException e){
		e.printStackTrace();
	}
	}
}
