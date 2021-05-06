#include <stdio.h> 
#include <stdlib.h> 
#include <unistd.h> 
#include <string.h> 
#include <sys/types.h> 
#include <sys/socket.h> 
#include <arpa/inet.h> 
#include <netinet/in.h> 
  
#define PORT     5500
#define ADDR "127.0.0.1" 
#define MAXLINE 1024 
  
int main() { 
    int sockfd; 
    char *hello = "Hello from server"; 
    struct sockaddr_in servaddr, cliaddr; 
      
    //Step 1: Creating socket file descriptor 
    if ( (sockfd = socket(AF_INET, SOCK_DGRAM, 0)) < 0 ) { 
        perror("socket creation failed"); 
        exit(EXIT_FAILURE); 
    } 
    // null out servaddr, cliaddr
    memset(&servaddr, 0, sizeof(servaddr)); 
    memset(&cliaddr, 0, sizeof(cliaddr)); 
      
    //Step 2:Bind address to socket
    servaddr.sin_family    = AF_INET; // IPv4 
    servaddr.sin_addr.s_addr = ADDR; 
    servaddr.sin_port = htons(PORT); 
     
    if ( bind(sockfd, (const struct sockaddr *)&servaddr,  
            sizeof(servaddr)) < 0 ) { 
        perror("bind failed"); 
        exit(EXIT_FAILURE); 
    }
    //Step 4: communicate with client
    int len, n; 
    char buffer[MAXLINE]; 
    len = sizeof(cliaddr);  //len is value/resuslt 
    while(1){
        n = recvfrom(sockfd, (char *)buffer, MAXLINE, 0,
            (struct sockaddr *) &cliaddr, &len); 
        buffer[n] = '\0'; 
        if(!strcmp(buffer, "quit") || !strcmp(buffer, "QUIT")){
            char *quit = "Disconnecting from server...\n";
            sendto(sockfd, (const char *) quit, strlen(quit),
                0, (const struct sockaddr *) &cliaddr, len);

        }
        printf("Received from client[%s:%d]: %s\n", inet_ntoa(cliaddr.sin_addr),
            ntohs(cliaddr.sin_port), buffer); 
        sendto(sockfd, (const char *)hello, strlen(hello),  
                0, (const struct sockaddr *) &cliaddr, len); 
        printf("Hello message sent.\n");  
    }
    return 0; 
} 