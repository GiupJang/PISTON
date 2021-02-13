import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _1_CalculatingGRS {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			
			BufferedReader input = new BufferedReader(new FileReader("C:/PISTON/dependency_graph.txt"));
			BufferedWriter output = new BufferedWriter(new FileWriter("C:/PISTON/GRS.txt"));
			BufferedReader neg_word = new BufferedReader(new FileReader("C:/PISTON/regulation_down.txt"));
			BufferedReader neg_word2 = new BufferedReader(new FileReader("C:/PISTON/regulation_down.txt"));
			BufferedReader pos_word = new BufferedReader(new FileReader("C:/PISTON/regulation_up.txt"));
			BufferedReader pos_word2 = new BufferedReader(new FileReader("C:/PISTON/regulation_up.txt"));
			
			int neg_loop = 0;
			
			while(true){
				
				String line = neg_word.readLine();
				if(line == null) break;
				neg_loop++;
				
			}
			
			String [] new_neg_word = new String [neg_loop];
			
			for(int i=0; i<neg_loop; i++){
				
				String line = neg_word2.readLine();
				new_neg_word[i] = line;
				
			}
			
			int pos_loop = 0;
			
			while(true){
				
				String line = pos_word.readLine();
				if(line == null) break;
				pos_loop++;
				
			}
			
			String [] new_pos_word = new String [pos_loop];
			
			for(int i=0; i<pos_loop; i++){
				
				String line = pos_word2.readLine();
				new_pos_word[i] = line;
				
			}
			
			while(true){
				
				int res = 1;
				int chk = 0;
				
				String line = input.readLine();
				if(line == null) break;
				String [] split_line = line.split("\t");
				int length = split_line.length;
				
				for(int i=0; i<neg_loop; i++){
					
					for(int j=2; j<length; j++){
						
						if(split_line[j].equals(new_neg_word[i])){
							
							chk=1;
							res = res * -1;
							
						}
						
					}
					
				}
				
				for(int i=0; i<pos_loop; i++){
					
					for(int j=2; j<length; j++){
						
						if(split_line[j].equals(new_pos_word[i])){
							
							chk=1;
							res = res * 1;
							
						}
						
					}
					
				}
				
				if(chk==1){
					
					output.flush();
					output.write(split_line[0]+"\t"+split_line[1]+"\t"+res+"\n");
					
				}

			}
		
			input.close();
			neg_word.close();
			neg_word2.close();
			pos_word.close();
			pos_word2.close();
			output.close();
		
		System.out.println("Process finished.");	
		
	}

}

