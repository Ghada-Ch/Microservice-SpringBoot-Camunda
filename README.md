# Microservice-SpringBoot-Camunda
During this project, we propose to study the process of granting credit to the customer within a bank.
The credit granting process is generally divided into three phases:
## I. Simulation phase and request
When the customer goes to the bank, his customer file containing his information is retrieved
automatically. If the customer is a new customer and does not exist in the database, a
new customer file is created. The customer record includes the following information:
  
▪ Last name & first name of the customer  
▪ CIN  
▪ Monthly salary  
▪ Type of contract (CDI, CDD or CIVP)  
▪ Date of birth  

The customer formulates his credit request by specifying the amount and the desired duration (in months) and the
system selects the scale best suited to the customer's situation from the catalog of
scales. A scale is characterized by:
  
▪ Scale reference (unique ID)  
▪ Nominal Rate: the rate to apply (Example: 1.5%)  
▪ Minimum Duration: Minimum duration over which the scale is applied  
▪ Maximum Duration: Maximum duration over which the scale is applied  
▪ Minimum Amount: Minimum amount to which the scale is applied  
▪ Minimum Amount: Maximum amount to which the scale is applied  
  
&rarr; The system must select the scale where the duration chosen by the customer is between duration
minimum and maximum duration of the scale as well as the amount desired by the customer is included
between the minimum amount and the maximum amount of the scale.  
&rarr; If the query returns several applicable scales, we select the scale with the rate
lowest nominal.  

Once the scale is selected, a credit file is created and a simulation of the amount
monthly payable is made. A credit file is characterized by:  
▪ Folder reference: Unique ID of the folder  
▪ Customer reference: Unique customer ID (CIN for example)  
▪ Loan amount  
▪ Scale reference: Reference of the selected scale  
▪ Interest: Loan amount * nominal rate (recovered from the scale)  
▪ Credit term  
▪ Monthly payment: (Loan amount + interest) / duration  
  
## II. Scoring phase
Once the file is saved we will go to the decision-making stage to do this, a
calculation and saving of the score are carried out. A score is between 0 and 100.  
▪ A score is identified by the following data:  
▪ File reference: credit application reference  
▪ Score: score to calculate  
▪ Score evaluation: Evaluation made according to the value of the score (Green or red)  
The first step of the score is to verify the existence of the customer in the bank's blacklist
Central Tunisia (a database containing customers in default of payment and who are
prohibited from obtaining credit). If the client's CIN is in the BCT blacklist, the score is
automatically equal to 0.  
If the customer does not exist in the BCT blacklist, a score calculation is performed according to the algorithm
next :  

`Score = 0`  
`If salaire > 2000 ➔ Score = score + 20`  
`If Salaire > 1000 et salaire <2000 ➔ Score = score + 10`  
`If type contrat == CDI ➔ Score = score + 30`  
`If Mensualité / salaire < 0.45 ➔ Score = score + 50`  

Once the score is calculated, an evaluation of the score is done according to the following rule:  
`If score < 50 ➔ Red Score otherwise Green Score`  
## III. Decision phase
Once the score is calculated an automatic decision is made. The decision is saved
in the database with the following attributes:  

▪ Request reference: Credit request reference  
▪ Decision date: Date when the decision was made (Normally sysdate)  
▪ Decision status = If score is red “Refusal” otherwise “Acceptance”  
