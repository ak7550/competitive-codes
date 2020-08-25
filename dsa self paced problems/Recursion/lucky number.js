let no=19;

console.log("Final output is: "+islucky(no));

function islucky(no) {
    let arr=[];

    for(let i=0;i<no;i++)
        arr.push(i+1);

    console.log(arr);
    let counter=1;
    return findLucky(arr,counter,no);
}


function findLucky(arr, counter,no) {
    if(counter>arr.length)
        return true;
    let i=counter;

    while (i<arr.length) {
        if(arr[i]==no)
            return false;
        console.log(`${arr[i]} will get deleted now.`);
        remove(arr,i);
        console.log(arr);
        i+=counter;
    }
    counter++;
    console.log(`counter is ${counter+1} for the next call.\n\n\n Array before calling the next element: \n ${arr}\n\n\n\n`);
    return findLucky(arr,counter,no);
}

function remove(arr, index) {
    for (let i = index; i < arr.length; i++) {
        arr[i]=arr[i+1];
    }
    arr.pop();
}