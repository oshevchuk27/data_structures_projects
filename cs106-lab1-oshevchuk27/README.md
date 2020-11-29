## CS 106 Lab 1 - Data Structure Design

Name: Olga Shevchuk

Number of Late Days Using for this lab:

0


1. If any of your validation methods indicate that your precondition assumptions were not met by the data, document what preconditions were violated
and in what way. Update your validation methods one error at a time, documenting all issues, until you can read in all the data. If this did not happen,
mention that.
All of my precondition assumptions were met by the data.

2. Describe a person who would generate data that would not pass your (updated) precondition assumptions.
A person with the race "Australian Aborigine" would not pass the precondition assumptions.

3. Find charges that, based on the r charge desc, you think should not count
as recidivism. Change your analysis using the two year recid outcome
indicator accordingly and rerun the analysis. Do this using an optionally
run method so that you can still run the previous version of the analysis
(your final submission should run only the original analysis so it can be
checked by the autograder). Describe the choices you made and what the
resulting analysis shows in your README.md.


I considered some recidivism charge descriptions that seemed for me too minor for the defendant to be counted as the one who re-offended. The ones that I picked were the Strings like "Sleeping On Beach", "Open Container Of Alcoholic Bev", "Drinking Alch Beverage In Open", "Disorderly Conduct", "Disobey Officer/Fireman", "Driving While License Revoked", "Loitering/ Prowling" which I deemed as too minor for a criminal offense. I created optional methods that would not count people with those descriptions as the ones who re-offended but would add them to the ones that did not re-offend. As can be observed from my testing, the number of defendants who re-offended both black and white (those that re-offended and those labeled low risk that re-offended) went down because the number of people with two year recidivism indicator "1" decreased but the number of defendants who did not re-offend both black and white (those that did not re-offend and those labeled high who did not re-offend) went up because the number of people who were taken out from those who re-offended are now the ones who did not re-offend. Corresponding to this, the percentages for those people who did not re-offend went up. However, the percentages for false negative white and black defendants changed differently. In particular, the percentage for false negative white defendants went up by 0.2% and the percentage for false negative black defendants went down by 0.1%. This can be explained by the change in numbers: for false negative white defendants the change was not as big as for false negative black defendants, the difference between the original numerator and denominator was much smaller than that for false negative black and the bigger change was in the denominator, so it resulted in the decrease of the percentage. On the other hand, for false negative black defendants the change in numbers was bigger than that for false negative white ones, the difference between the original numerator and denominator was bigger than for false negative white, and the bigger change was in the denominator which resulted in the slight increase of the percentage. 
 

### Lab Questionnaire

(None of your answers below will affect your grade; this is to help refine lab
assignments in the future)

1. Approximately, how many hours did you take to complete this lab? (provide
  your answer as a single integer on the line below)
   13
2. How difficult did you find this lab? (1-5, with 5 being very difficult and 1
  being very easy)
   4
3. Describe the biggest challenge you faced on this lab:
The biggest challenge for me was to figure out how to read the data correctly and perform the analysis change based on the recidivism charge degrees descriptions. 
