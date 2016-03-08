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

//����������Դ��Ϣ
public class generateOrigin {

	public static void main(String[] args) {
		generateOrigin obj = new generateOrigin();
		File metaDataQuad = new File("metaData.quad");
		File originDataQuad = new File("originData.quad");

		BufferedReader reader = null;
		List<String> list = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(metaDataQuad));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				list.add(tempString);
			}
			FileWriter originDataQuadWriter = new FileWriter(originDataQuad.getName(), true);
			BufferedWriter originQuadBuffer = new BufferedWriter(originDataQuadWriter);
			int length = list.size();
			String temp1, temp2, temp3, temp4, temp5, temp6;
			long random1, random2, random3;
			double lon, lat;// ���������γ���Լ�ID
			String LON, LAT;
			DecimalFormat df = new DecimalFormat("######0.0000");
			for (int i = 0; i < length; i++) {
				temp1 = list.get(i);
				temp2 = temp1.substring(temp1.indexOf("<"), temp1.indexOf(">") + 1);// ȡ��s

				// �������Origin
				random1 = obj.randomDataGenerater(10000, 99999);
				random2 = obj.randomDataGenerater(10000, 99999);
				random3 = obj.randomDataGenerater(1000, 9999);//
				temp3 = " <http://yago-knowledge.org/origin/example_" + random1 + random2 + random3 + ">";// ����Origin

				// �������ID��origin
				random1 = obj.randomDataGenerater(10000, 99999);
				random2 = obj.randomDataGenerater(10000, 99999);
				random3 = obj.randomDataGenerater(1000, 9999);//
				temp4 = " <http://yago-knowledge.org/resource/id_" + random1 + "_" + random2 + "_" + random3 + ">.\n";// origin��ID

				temp5 = " <http://yago-knowledge.org/resource/origin> ";
				originQuadBuffer.write(temp2 + temp5 + temp3 + temp4);
			}
			originQuadBuffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ���������
	public long randomDataGenerater(long min, long max) {
		long temp;
		temp = (long) (Math.random() * (max - min)) + min;
		return temp;
	}

	// �������������
	public double randomFloatDataGenerater(double min, double max) {
		double temp;
		temp = (double) (Math.random() * (max - min)) + min;
		return temp;
	}
}
