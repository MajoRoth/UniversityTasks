/*
 *
 * */

#include "stdio.h"
#include <stdlib.h>
int * partialSums(int a[], int size);

int main() {
    int *arr, *p;
    int i, size;
    printf("Please provide the size of the array:\n");
    scanf("%d", &size);
    arr = (int *)malloc(size * sizeof(int));
    for(i=0; i<size; i++)
    {
        printf("Enter a number: (Enter to submit)\n");
        scanf("%d", (arr+i));
    }
    printf("\nThe given array is:\n");
    for (i = 0; i < size; i++){
        printf("%d\n", *(arr+i));
    }
    printf("\npartialSums array is:\n");

    p = partialSums(arr, size);
    for (i = 0; i < size; i++){
        printf("%d\n", *(p+i));
    }
}

int * partialSums(int a[], int size)
{
    int *arr;
    int sum=0, i;
    arr = (int *)malloc(size * sizeof(int));
    for (i=0; i<size; i++)
    {
        sum += *(a+i);
        *(arr+i) = sum;
    }
    return arr;
}

