


'''

Created on 

@author: Raja CSP Raman

source:


'''




def get_spaces(content):

    if(len(content) < 3):
        return (" " * (4 - len(content)))
    
    if(len(content) < 8):
        return (" " * (8 - len(content)))
    
    if(len(content) < 12):
        return (" " * (12 - len(content)))
    
    if(len(content) < 16):
        return (" " * (16 - len(content)))
    
    if(len(content) < 20):
        return (" " * (20 - len(content)))


def convert_num(s):
    try:
        return int(s)
    except ValueError:
        return s
    
def is_int(c_item):

    c_item = convert_num(c_item.strip())

    return (isinstance(c_item, int))


def find_digit_index_in_list(address_list):

    for c_index, c_item in enumerate(address_list):

        # print(f'{c_index} : [{c_item}] : {isinstance(c_item, numbers.Number)}')

        if(is_int(c_item)):
            return c_index

    return 0

def get_single_content(item, tag):

    content = ""

    content += f"{item}"
    content += f"{get_spaces(item)}"
    content += f"{tag}"
    content += "\n"

    return content


def pattern_1_maker_single(address):

    '''
        Pattern 1:

        Sample:
        14 KINGSFORD SMITH AVE
    '''

    address_parts = address.split(" ")

    content = ""

    for c_item in address_parts:

        c_item = c_item.strip()

        if(len(c_item) == 0):
            continue
        content += get_single_content(c_item, "0")

    return content

def pattern_maker_single(c_line, pattern_index):

    if(pattern_index == 1):
        return pattern_1_maker_single(c_line)

    return 0

def pattern_maker_multiple(pattern_index):

    file = f'pattern{pattern_index}.txt'

    lines = None
    with open(file) as f:
        lines = f.readlines()

    # print(lines)

    content = ""

    for c_line in lines:
        c_line = c_line.replace('\n', '')

        content += pattern_maker_single(c_line, pattern_index)

        content += "\n\n"

    # print(content)

    return content

def startpy():

    # Pattern 1
    print(pattern_maker_multiple(1))

if __name__ == '__main__':
    startpy()
