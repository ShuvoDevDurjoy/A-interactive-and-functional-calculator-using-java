# Basic calculator using java
Hi , 👋 . Hope you are well . Nice to see you here . This is a basic calculator i created using java, while doing Java course in my university (North South University). In this calculator i tried to give many user-friendly feature that are attached below <br>
## Here is the demo image
![alt text](Images/Calcutor%20demo%20image.png)
<br>
# Difficulty with programming a calculator in java
As in java there is no `eval()` function as in  <strong>Javascript</strong> , that can automatically perform all the mathematical operation on a string and gives us the answer . So, i had to hardcode all the mathematical calculation . 
## Here below are some of the major functionality of the calculator operations
1. <blockquote>At first , the calculator can not only calculate <span style="color : yellow">1+2</span> but also can calculate a string like <span style="color : yellow">.2+3+4/5+6*3.4-1223+34</span> and for floating point show answer rounding that off . Here <span style="color : yellow">Rounding off </span> is necessary because in java floating and double number are stored as <span style="color : yellow">64-bit</span> , so they are not precise in real . <hr>
2. <blockquote><p style=" color : cyan " >The most interesting feature of the calculator is that it does not evaluate a mathematical expression from 'left to right' or 'right to left' , it follows the precedence rules , that means , it at first evaluate a <span style="color : yellow">/</span> operator if any , then evaluate <span style="color : yellow">*</span> operator if any  and then evaluate the resulting expression that is left with only <span style="color : yellow">+ and -</span> operator from left to right . You may understand how tough it is , in program ! <hr>  

3. <blockquote>When the input field is empty , then pressing any operator is not accepted except , as the calculator is designed to calculate negative and floating point values as well.<hr>

4. <blockquote>After pressing <span style="color : yellow">+</span> operator if the user press <span style="color : yellow">* or /</span> then the <span style="color : yellow">+</span> operator is going to be replaced by the recently pressed operator.<em>But</em> if the user press <span style="color : yellow">- or . </span> operator then the previous operator is not going to be replaced if they do not match . <hr>
5. <blockquote>After pressing a decimal point as long as an operator is not pressed so long another decimal point can not be pressed . That means , <span style="color : yellow">1.2. is not allowed</span> but <span style="color : yellow">1.2+.4 is allowed</span>.<hr>
6. <blockquote>If user typed any <span style="color : yellow">invalid input</span> like <span style="color : yellow">a , b or ++ using keyboard </span>then the code going to show an ERROR in the output field.<hr>
7. <blockquote>There is a <span style="color : yellow">delete</span> button which will delete attribute one by one from the input field as many time it will be pressed .<hr>
8. <blockquote>There is an <span style="color : yellow">AC</span> button that will clear the input and output field both .<hr>
9. <blockquote>There is a <span style="color : yellow">ANS</span> button which will evaluate the input expression as well . <hr>
10. <blockquote>If user press <span style="color : yellow">=</span> for a input like <span style="color : yellow">1+2.3+</span> the programe also going to evaluate the expression and will show the output as <span style="color : yellow">1+2.3=3.3</span> and if the user again press <span style="color : yellow">=</span> then the input expression is going to be again appear in input field in the format like <span style="color : yellow">1+2.3+</span>
