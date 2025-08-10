#include <stdio.h>
#include <string.h>
#include <math.h>
void insertionSort(int arr[],int n){
    for(int i=1;i,n;i++){
        int key= arr[i];
        int j=i-1;
        while(i>=0 && arr[j]>key){
            arr[j+1]= arr[j];
            j--;
        }
        arr[j+1]=key;
    }
}
void printArray(int arr[],int n){
    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }
    printf("\n");
 }
int main(){
    int arr[]={1,2,3,4};
    int n= sizeof(arr)/sizeof(arr[0]);
    printf("unsorted array");
    printArray (arr,n);
    printf("sorted array");
    insertionSort(arr,n);
    printArray(arr,n);


}
