
# library-app , JAVA,AWS,S3,RDS,EC2,Parameter Store
Projeto de exemplo implementação de uma api utilizando springboot utilizando infraestrutura Aws com os recursos abaixo:
- backend: Java SpringBoot
- banco de dados: MySQL 8
- AWS S3
- AWS RDS 
- AWS EC2
- AWS Parameter Store
- AWS VPC
- AWS IAM
- Angular 14


Arquitetura da solução:
![diagramalibrary](https://user-images.githubusercontent.com/37355015/204369992-aea925fe-95c3-4f6a-9824-1d5927396d16.png)

Steps:
1 - Criar a aplicação Springboot
2 - Criar a aplicação front em Angular
3 - Criar o banco de dados na Aws utilizando o serviço Rds
4 - Criar a instância ec2 da aplicação na aws
5 - Criar Bucket S3 para armazenamento das imagens da aplicação
6 - Criar um Bucket no S3 para hospedar a aplicação front do Angular servless
7 - Configurar o aws parameter store para para armazenar variaveis
8 - Criar um usuário no IAM com permissão acesso ao S3 e ao Parameter Store
9 - Configurar permissões no security group da aplicação Inbound e Outbound
