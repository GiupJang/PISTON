import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _2_CalculatingGRSsum {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader input = new BufferedReader(new FileReader("C:/PISTON/GRS.txt"));
		BufferedReader input2 = new BufferedReader(new FileReader("C:/PISTON/GRS.txt"));
		BufferedReader drug = new BufferedReader(new FileReader("C:/PISTON/selected_drug.txt"));
		BufferedReader drug2 = new BufferedReader(new FileReader("C:/PISTON/selected_drug.txt"));
		BufferedReader gene = new BufferedReader(new FileReader("C:/PISTON/selected_gene.txt"));
		BufferedReader gene2 = new BufferedReader(new FileReader("C:/PISTON/selected_gene.txt"));
		
		int drug_loop = 0;
		
		while(true){
			
			String line = drug.readLine();
			if(line == null) break;
			drug_loop++;
			
		}
		
		String [] new_drug = new String [drug_loop];
		
		for(int i=0; i<drug_loop; i++){
			
			String line = drug2.readLine();
			new_drug[i] = line;
			
		}
		
		int gene_loop = 0;
		
		while(true){
			
			String line = gene.readLine();
			if(line == null) break;
			gene_loop++;
			
		}
		
		String [] new_gene = new String [gene_loop];
		
		for(int i=0; i<gene_loop; i++){
			
			String line = gene2.readLine();
			new_gene[i] = line;
			
		}
		
		int input_loop = 0;
		
		while(true){
			
			String line = input.readLine();
			if(line == null) break;
			input_loop++;
			
		}
		
		String [] new_input = new String [input_loop];
		
		for(int i=0; i<input_loop; i++){
			
			String line = input2.readLine();
			new_input[i] = line;
			
		}
		
		for(int i=0; i<drug_loop; i++){
			
			System.out.println(i+" / "+drug_loop);
			
			BufferedWriter output = new BufferedWriter(new FileWriter("C:/StudyData/TopicModeling/Drug/"+new_drug[i]+".txt"));
			
			for(int j=0; j<gene_loop; j++){
				
				int sum = 0;
				
				for(int k=0; k<input_loop; k++){
					
					String [] split_line = new_input[k].split("\t");
					
					if(split_line[0].equals(new_drug[i]) && split_line[1].equals(new_gene[j]) && split_line[2].equals("1")){
						
						sum = sum + 1;
						
					}
					else if(split_line[0].equals(new_drug[i]) && split_line[1].equals(new_gene[j]) && split_line[2].equals("-1")){
						
						sum = sum - 1;
						
					}
		
				}
		
				if(sum > 0){
					
					output.flush();
					output.write(new_gene[j]+"+"+"\n");
					
				}
				else if(sum < 0){
					
					output.flush();
					output.write(new_gene[j]+"-"+"\n");
					
				}
	
			}
			
			output.close();
			
		}

		input.close();
		input2.close();
		drug.close();
		drug2.close();
		gene.close();
		gene2.close();
		
		System.out.println("Process finished.");	
		
	}

}

