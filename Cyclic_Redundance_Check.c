#include <stdio.h>
int main(void)
{
    int data[50], div[16], rem[16];
    int datalen, divlen, i, j, k;
    int ch;
    printf("Enter the data: ");
    i = 0;
    while ((ch = fgetc(stdin)) != '\n')
    {
        if (ch == '1')
            data[i] = 1;
        else
            data[i] = 0;
        i++;
    }
    datalen = i;
    setbuf(stdin, NULL);
    setbuf(stdout, NULL);
    printf("\nEnter the divisor: ");
    i = 0;
    while ((ch = fgetc(stdin)) != '\n')
    {
        if (ch == '1')
            div[i] = 1;
        else
            div[i] = 0;
        i++;
    }
    divlen = i;
    for (i = datalen; i < datalen + divlen - 1; i++)
        data[i] = 0;
    datalen = datalen + divlen - 1;
    for (i = 0; i < divlen; i++)
        rem[i] = data[i];
    k = divlen - 1;
    while (k < datalen)
        if (rem[0] == 1)
        {
            for (i = 0; i < divlen; i++)
                rem[i] = rem[i] ^ div[i];
        }
        else
        {
            if (k == datalen - 1)
                break;
            for (i = 0; i < divlen - 1; i++)
            {
                rem[i] = rem[i + 1];
                printf("%d", rem[i]);
            }
            rem[i] = data[++k];
            printf("%d\n", rem[i]);
        }
    j = 1;
    for (i = datalen - divlen + 1; i < datalen; i++)
    {
        data[i] = rem[j++];
    }
    printf("\nThe data to be sent is\n");
    for (i = 0; i < datalen; i++)
        printf("%d", data[i]);
    return 0;
}