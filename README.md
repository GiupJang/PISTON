[PISTON v1.0]
Created by Giup Jang
Data Mining & Bioinformatics Laboratory,
Gachon University, Republic of Korea
E-mail: giupjang0207@gmail.com

PISTON is a model that discover novel drug indications and side effects using natural language processing and topic modeling.

Environment in this study:
Eclipse Luna Service Release 2 (4.4.2)
JDK 1.8.0_45
R 3.3.2
Stanford parser 3.6.0

PISTON runs in 5 phases as follows:
1. Calculate GRS between drugs and genes using refined data based on natural language processing tool.
2. Calculate GRSsum using GRS and identify GRPs for each drug.
3. Discover the number of optimal topics and construct drug-topic probability matrix using R package.
: This will take some time. In this study, we took about 10-12 hours to get the results.
4. Assign a class label using known drug-phenotype associations.
5. Leave the topics which have the highest ranking of known drugs from drug-topic probability matrix.

============================================================================================================

[1. _1_CalculatingGRS.java]
Usage:
Dependency_graph.txt / regulation_up.txt / regulation_down.txt
Explanation:
<Dependency_graph.txt>
Extract and refine words describing drugs and genes using natural language processing techniques.
We used Stanford parser in this study.
<regulation_up.txt / regulation_down.txt>
A dictionary that defines up-/down-regulation in words that describe between the drug and the gene.

[2. _2_CalculatingGRSsum.java]
Usage:
selected_drug.txt / selected_gene.txt
Data explanation:
<selected_drug.txt / selected_gene.txt>
Drug and gene objects that were identified in the sentences.

[3. _3_ConstructingDrugTopicMatrix.Rhistory]
Usage:
Drug*.txt (in Drug folder)
Data explanation:
<Drug*.txt>
A file containing GRPs for each drug

[4. _4_AssigningClass.java]
Usage:
LDAGibbs_284_TopicProbabilities.csv / LDAGibbs_284_TopicProbabilities.txt / gold_standard.txt
Data explanation:
<LDAGibbs_284_TopicProbabilities.csv>
Drug-topic probability matrix (the output of phase 3)
<LDAGibbs_284_TopicProbabilities.txt>
Rank the probabilities for each drug
We used rank() function in Excel (descending order)
<gold_standard.txt>
The list of drugs that treat a phenotype (MeSH unique ID)

[5. _5_LeavingMaximumTopics.java]
Usage:
LDAGibbs_284_TopicProbabilities.txt / assigned_class.txt / integrating_matrix.txt
Data explanation:
<integrating_matrix.txt>
The file that was integrate LDAGibbs_284_TopicProbabilities.txt with assigned_class.txt.
