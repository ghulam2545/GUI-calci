from tkinter import *
root = Tk()
root.geometry('280x300')
root.title('GUI Calculater')
root.minsize(280,300)
root.maxsize(280,300)

def btn_click(num):
    entry = e.get()
    e.delete(0, END)
    global value
    value = str(entry) + num
    e.insert(0,value)

def btn_clear():
    e.delete(0, END)

def btn_eual():
    add = False
    subs = False
    mul = False
    div = False

    for i in range(0, len(value)):
        if value[i] == '+':
            x = re.split('\+',value)
            add = True

        elif value[i] == '-':
            x = re.split('\-',value)
            subs = True 
        elif value[i] == '*':
            x = re.split('\*',value)
            mul = True
        elif value[i] == '/':
            x = re.split('\/',value)
            div = True          
        else:
            pass

    if add == True:
        e.delete(0, END)
        e.insert(0, int(x[0]) + int(x[1]))
    elif subs == True:
        e.delete(0, END)
        e.insert(0, int(x[0]) - int(x[1]))
    elif mul == True:
        e.delete(0, END)
        e.insert(0, int(x[0]) * int(x[1]))
    elif div == True:
        e.delete(0, END)
        e.insert(0, float(int(x[0]) / int(x[1])))

# --------  GUI Component-----------
e = Entry(root,font=('arial',15,'bold'),justify='center',borderwidth=4,relief='sunken',width=22)
e.grid(row=0,column=0,padx=0,pady=4)
f1 = Frame(root)
f1.grid(row=1,padx=17,pady=8)
Button(f1,text='1',padx=20,pady=7,font=('arial',12,'bold'),command=lambda: btn_click('1')).grid(row=1,column=0)
Button(f1,text='2',padx=20,pady=7,font=('arial',12,'bold'),command=lambda: btn_click('2')).grid(row=1,column=1)
Button(f1,text='3',padx=20,pady=7,font=('arial',12,'bold'),command=lambda: btn_click('3')).grid(row=1,column=2)
Button(f1,text='4',padx=20,pady=7,font=('arial',12,'bold'),command=lambda: btn_click('4')).grid(row=1,column=3)
Button(f1,text='5',padx=20,pady=7,font=('arial',12,'bold'),command=lambda: btn_click('5')).grid(row=2,column=0)
Button(f1,text='6',padx=20,pady=7,font=('arial',12,'bold'),command=lambda: btn_click('6')).grid(row=2,column=1)
Button(f1,text='7',padx=20,pady=7,font=('arial',12,'bold'),command=lambda: btn_click('7')).grid(row=2,column=2)
Button(f1,text='8',padx=20,pady=7,font=('arial',12,'bold'),command=lambda: btn_click('8')).grid(row=2,column=3)
Button(f1,text='9',padx=20,pady=7,font=('arial',12,'bold'),command=lambda: btn_click('9')).grid(row=3,column=0)
Button(f1,text='0',padx=20,pady=7,font=('arial',12,'bold'),command=lambda: btn_click('0')).grid(row=3,column=1)
Button(f1,text='+',padx=51,pady=7,font=('arial',12,'bold'),command=lambda: btn_click('+')).grid(row=3,column=2,columnspan=2)
Button(f1,text='-',padx=20,pady=5,font=('arial',14,'bold'),command=lambda: btn_click('-')).grid(row=4,column=0)
Button(f1,text='*',padx=20,pady=5,font=('arial',14,'bold'),command=lambda: btn_click('*')).grid(row=4,column=1)
Button(f1,text='/',padx=20,pady=5,font=('arial',14,'bold'),command=lambda: btn_click('/')).grid(row=4,column=2)
Button(f1,text='=',padx=17,pady=29,font=('arial',14,'bold'),command=btn_eual).grid(row=4,column=3,rowspan=2)
Button(f1,text='Clear',padx=67,pady=7,font=('arial',12,'bold'),command=btn_clear).grid(row=5,column=0,columnspan=3)

# ----------------  End of GUI Component---------
root.mainloop()
