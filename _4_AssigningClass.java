import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class __4_AssigningClass {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader label = new BufferedReader(new FileReader("C:/PISTON/gold_standard.txt"));
		BufferedReader label2 = new BufferedReader(new FileReader("C:/PISTON/gold_standard.txt"));
		BufferedReader table = new BufferedReader(new FileReader("C:/PISTON/LDAGibbs_284_TopicProbabilities.txt"));
		BufferedReader table2 = new BufferedReader(new FileReader("C:/PISTON/LDAGibbs_284_TopicProbabilities.txt"));
		BufferedWriter output = new BufferedWriter(new FileWriter("C:/PISTON/assigned_class.txt"));

		int label_loop = 0;
		
		while(true){
			
			String line = label.readLine();
			if(line == null) break;
			label_loop++;
			
		}
		
		String [] new_label = new String [label_loop];
		
		for(int i=0; i<label_loop; i++){
			
			String line = label2.readLine();
			new_label[i] = line;
			
		}
		
		int table_loop = 0;
		
		while(true){
			
			String line = table.readLine();
			if(line == null) break;
			table_loop++;
			
		}
		
		String [] new_table = new String [table_loop];
		String [] assigned_label = new String [table_loop];
		
		for(int i=0; i<table_loop; i++){
			
			String line = table2.readLine();
			new_table[i] = line;
			
		}

		for(int i=0; i<table_loop; i++){
			
			int temp = 0;
			
			String [] split_topic = new_table[i].split("\t");
			
			for(int j=0; j<label_loop; j++){
				
				if(split_topic[3].equals(new_label[j])){

					temp = 1;
					
				}
				
			}
			
			if(temp==1){
				
				assigned_label[i] = "T";
				output.flush();
				output.write(assigned_label[i]+"\n");
				
			}
			else{
				
				assigned_label[i] = "F";
				output.flush();
				output.write(assigned_label[i]+"\n");
				
			}
			
		}

		label.close();
		label2.close();
		table.close();
		table2.close();
		output.close();
		
		System.out.println("Process finished.");	
		
	}

}
