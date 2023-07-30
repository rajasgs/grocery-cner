




'''
Created on 

@author: Raja CSP Raman

source:
    https://docs.google.com/spreadsheets/d/1JOK1mFmOZb1S3sf-6VDSkqlxZhc31OcAAXYv51823FE/edit#gid=0

    Benchmark
    https://docs.google.com/spreadsheets/d/1JOK1mFmOZb1S3sf-6VDSkqlxZhc31OcAAXYv51823FE/edit#gid=1530735689
'''

from datetime import datetime
import simple_transformer_loader as stl
import pandas as pd

LIMIT = 1000

def startpy():

    start_time = datetime.now()

    df = pd.read_csv('~/datasets/Grocery Purchase Orders Voice - base.csv')

    # print(len(df))
    # return

    order_list = df['Orders'].to_list()

    for c_index, item in enumerate(order_list[0:LIMIT]):
        # print(item)
    
        result = stl.get_cnered_content(item)

        # print(c_index, result)
        print(c_index)

    _secs = (datetime.now() - start_time).total_seconds()
    print('Time : ', int(_secs))

if __name__ == '__main__':
    startpy()