import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class __5_LeavingMaximumTopics {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader table = new BufferedReader(new FileReader("C:/PISTON/integrating_matrix.txt"));
		BufferedReader table2 = new BufferedReader(new FileReader("C:/PISTON/integrating_matrix.txt"));
		BufferedWriter output = new BufferedWriter(new FileWriter("C:/PISTON/leaving_max_topic_matrix.txt"));
		
		int table_loop = 0;
		
		while(true){
			
			String line = table.readLine();
			if(line == null) break;
			table_loop++;
			
		}
		
		String [] new_table = new String [table_loop];
		
		for(int i=0; i<table_loop; i++){
			
			String line = table2.readLine();
			new_table[i] = line;
			
		}
		
		String [] temp = new String [290];
		
		for(int i=0; i<290; i++){
			
			if((i==3) || (i==289)){
				
				temp[i] = "1";
				
			}
			else{
				
				temp[i] = "0";
				
			}
			
		}
		
		for(int i=0; i<table_loop; i++){
			
			String [] split_table = new_table[i].split("\t"); 
			String max = split_table[288];
			String label = split_table[289];
			
			for(int j=4; j<290; j++){
				
				if((split_table[j].equals(max)) && (label.equals("T"))){
					
					temp[j] = "1";
					
				}
				
			}
			
		}
		
		for(int i=0; i<table_loop; i++){
			
			String [] split_table = new_table[i].split("\t"); 
			
			for(int j=0; j<split_table.length; j++){
				
				if(temp[j].equals("1") && (j!=288)){
					
					output.flush();
					output.write(split_table[j]+"\t");
					
				}
				
			}
			
			output.flush();
			output.write("\n");
			
		}
		
		table.close();
		table2.close();
		output.close();
		
		System.out.println("Process finished.");	
		
	}

}
