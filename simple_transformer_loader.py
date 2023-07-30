




'''
Created on 

@author: Raja CSP Raman

source:
    https://docs.google.com/spreadsheets/d/1JOK1mFmOZb1S3sf-6VDSkqlxZhc31OcAAXYv51823FE/edit#gid=0
'''


from simpletransformers.ner import NERModel

model = NERModel('bert', 'outputs/', use_cuda=False)

def get_cnered_content(content):

    global model

    prediction, model_output = model.predict([content])

    return prediction


def startpy():
    
    result = get_cnered_content("I need 5 KGS of whole wheat flour for baking.")

    print(result)

if __name__ == '__main__':
    startpy()