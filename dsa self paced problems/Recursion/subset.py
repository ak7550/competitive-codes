def subset(pr,index,st):
    if(index!= st.length-1):
        subset(pr,index+1,st)
        subset(pr+st[index],index+1,st)
    print(pr)

def main():
    st=str(input("Enter the string to find subsets: "))
    subset("",0,st)
if __name__ == "__main__":
    main()