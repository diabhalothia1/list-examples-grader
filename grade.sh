# Create your grading script here

rm -rf student-submission
git clone $1 student-submission
RESULT="0"

# check if ListExamples.java exists
cd student-submission
if [ -f ListExamples.java ]
then
    echo "ListExamples.java file found"
else
    echo "ListExamples.java file not found"
    echo "Result is: "$RESULT
    exit 1
fi

cd ..
cp -r lib student-submission/
cp TestListExamples.java student-submission/
cd student-submission
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java

# check that the compile went fine
if [ $? -eq 00 ]
then
    echo "Compilation succeeded"
else
    echo "Compilation failed"
    echo "Result is: "$RESULT
    exit 1
fi

java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples

if [ $? -eq 00 ]
then
    RESULT=2
    echo "Result is: "$RESULT
else
    echo "Result is: "$RESULT
fi




