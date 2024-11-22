<h1 align="center">Eco Power ☀️ </h1>

<div align="center">


| Integrantes      |            Responsabilidades          | Turma      |   RM     |
| --------------   | ------------------------------------- | ---------- | -------- |
| Cauã Couto       | Desenvolvimento do projeto em Java    |  2TDSS     |  97755   |
| Eduardo Júnio    | Documentação do sistema               |  2TDSPV    |  552374  |
| José dos Santos  | Documentação do sistema               |  2TDSS     |  552367  |
| Kaique Agostinho | Mapeamento das tabelas e relações     |  2TDSS     |  550815  |
| Thiago Gil       | Mapeamento das tabelas e relações     |  2TDSPV    |  551211  |
</div>

## 📝 Descrição do Projeto 

> EcoPower é uma plataforma integrada e inteligente projetada para otimizar o consumo de energia em tempo real, tanto para empresas quanto para residências

Nossa solução visa proporcionar não só a redução de custos, mas também a contribuiçãoo para práticas sustentáveis, ao promover o uso eficiente da energia. A plataforma oferece uma interface de
fácil acesso, com versões web e mobile, onde os usuários podem monitorar o consumo, gerar relatórios detalhados e tomar decisões baseadas em dados analíticos. Além disso, o sistema promove a integração com fontes de energia renováveis, como solar e eólica, e sugere práticas sustentáveis de consumo, ajudando seus usuários a reduzirem sua pegada de carbono e custos com energia elétrica.

<h2 name="objetivo">🎯 Objetivos do Projeto</h2>
<li> Monitoramento em tempo real do consumo energético </li>
<li> Análise e relatórios detalhados sobre padrões de consumo e oportunidades de economia </li>
<li> Agendamento inteligente para otimização do uso de dispositivos </li>
<li> Integração com fontes de energia renováveis e recomendações para práticas sustentáveis </li>

## 📋  Modelo Relacional das Entidades 
❗❗ Acesse o Modelo Relacional das Entidades <a href="https://github.com/ccoutob/eco_power_java/blob/a5479b712bfddcbf18e0f27b8812290c9c5af792/EcoPower_Modelo_Relacional.pdf">AQUI</a> ❗❗


<div>
<h1 align="center"> 📦 Pacotes do Projeto </h1>

<h2> 📦 Model </h2>
<li> Pacote contém as classes responsáveis por serem as base de modelagem da aplicação</li>
<li> Classes responsáveis por mapearem a tabela do Banco de Dados e suas colunas de acordo com as regras de negócio </li>

<h2> 📦 Dto </h2>
<li> A classe deste pacote está responsável pelo mapeamento das transferências que serão feitas no pacote controller para o Usuário</li>

<h2> 📦 Repository </h2>
<li> As classes contidas nesse pacote são responsáveis pela persistência JPA das tabelas</li>
<li> Essas classes serão utilizadas na controller para acessarmos o banco de dados</li>

<h2> 📦 Controller </h2>
<li> As classes contidas nesse pacote são responsáveis por controlarem as requisições que faremos no Postman</li>
<li> Contém o CRUD do projeto com os métodos GET, POST, PUT e DELETE</li>

<h2> 📦 Service </h2>
<li> A classe contida nesse pacote é responsável por armazenar o usuário da aplicação no banco de dados e validar se ele existe</li>

<h2> 📦 Configuration </h2>
<li> As classes contidas nesse pacote são responsáveis por realizarem a validação de permissões do usuário </li>
<li> O login e senha dos possíveis usuários também estão armazenados nesse pacote</li>

<h2> 📦 Templates </h2>
<li> Neste pacote encontramos a estrutura do projeto para o front-end da aplicação, local onde o usuário terá acesso</li>
<li> Contém o cadastro, edição, exclusão e listagem (CRUD) das entidades de nosso projeto</li>
</div>

<h1>Sem anonimato 🕵️</h1> 
<li>Com o sistema de login, nenhum usuário de fora do nosso sistema poderá realizar qualquer ação de CRUD de nossa aplicação</li>
🔒 Login de ADMIN -> user: admin / password: ecopoweradm
<br>
🔒 Login de USUARIO -> user: customer / password: generic
</br>

## ❗❗ COMO NOSSO SISTEMA FUNCINA ❗❗
<li> Inicie a aplicação spring após clonar o repositório ou baixar o arquivo do projeto</li>
<li> Após iniciada a aplicação, utilize "http://localhost:8080" para ir a tela de login</li>
<li> Confira os usuários disponíveis a serem utilizados na classe "DataInitializer" contida no pacote "Configuration" </li>
<li> Uma vez logado no sistema, navege por ele e realize as ações desejadas </li>

<br>

## Para mais informações sobre o sistema, acesse nosso vídeo demonstrativo:
<a href="https://youtu.be/2V5bbAGjnDU">Vídeo demonstrativo</a>

### 🧑🏻‍💻 Autor 
> Cauã Couto Basques - Turma 2TDSS
