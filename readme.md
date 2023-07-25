


How to run vanilla code?
```
To create a pattern:
conda activate <env_name>
python pattern_maker.py

To train a model
java -cp "./jars/*:." TrainModel.java

you will see something like this output:
see output.txt

To test the generated model
java -cp "./jars/*:." TestNER.java

```


Custom NERs:
```
FOOD_ITEM
MEASUREMENT
RECIPE

Sample:

```



Where to get the grocery_unique.csv file?
```
Download from Dataset given below
```

Dataset:
```
Grocery Purchase Orders Voice
https://docs.google.com/spreadsheets/d/1JOK1mFmOZb1S3sf-6VDSkqlxZhc31OcAAXYv51823FE/edit#gid=0
```



How to run flask?
```
python app.py

needed to run the flask app:
grocery_track.json (clone and edit the grocery_track.sample.json)
grocery_unique.csv (see above)
```


To Do:
```
1. Each UI should show how many entries done so far?

2. If the text input is empty, it should be considered as 0


```