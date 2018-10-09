<h1> JPA - Hibernate </h1>

<p>Exemplo básico de persistência no banco de dados mysql com jpa utilizando hiberante</p>

<h2>Requisitos</h2>
<p>Banco de dados - MySQL (pode ser utilizando outro banco, no meu caso utilizei a versão 5.7 do MySQL)</p>
<p>Hibernate (Utilizei a ultima versão atual do hibernate que era 5.36.Final) Link para download: http://hibernate.org/orm/releases/</p>
<p>Driver de Conexão do Java com o banco de dados MySQL Connector/J - Link para download https://dev.mysql.com/downloads/connector/j/5.1.html</p>


<h2>Java JPA</h2>
<p>No banco de dados MySQL unica coisa que irá ter que fazer manualmente é a criação da database, no meu caso o nome do banco é escola - create database escola</p>

<h3> modelo </h3>
<p>No Java deve criar as classes modelo e realizar o mapeamento nas classes modelo. Em cima do nome da classe adicionar a anotação @Entity javax.persistence
a chave primaria deve ser mapeada com a anotação @Id javax.persistence e @GeneratedValue(strategy = GenerationType.IDENTITY) javax.persistence </p>

<h3>persistence.xml</h3>
<p>Para o hibernate funcionar corretamente como você deseja é necessário criar um arquivo de configuração persistence.xml esse arquivo deve 
ficar na pasta META-INF(nome deve ser escrito em letras maiusculas) que seve ser criado no diretório source da aplicação(src) src\META-INF\persistence.xml </p>

<p>Importante! Dentro do arquivo persistence.xml o nome da persistencia(você pode escolher qualquer nome, no meu caso escolhi o nome "escola") <persistence-unit name="escola"></p>
<p>Configurar os parametros de conexão com o banco (url, pass, senha, driver)</p>
<p>Configurar o modo em que o hibernate irá conversar com o banco de dados (hibernate.dialect)</p>
<p>Configurar o modo em que o hibernate irá realizar as transações com o banco de dados. (validate | update | create | create-drop)</p>

<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0"
	xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
	
	<persistence-unit name="escola" transaction-type="RESOURCE_LOCAL">
		
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
		
		<class>br.com.estudo.modelo.Aluno</class>
		<class>br.com.estudo.modelo.Professor</class>
		
		<properties>
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/escola"/>
			<property name="javax.persistence.jdbc.user" value="root"/>
			<property name="javax.persistence.jdbc.password" value="root"/>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
			
			<!-- validate | update | create | create-drop -->
			<property name="hibernate.hbm2ddl.auto" value="create-drop"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL55Dialect"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.show_sql" value="true"/>
		</properties>
	
	</persistence-unit>
	
</persistence>



<h2>Persistir os dados no banco de dados</h2>
<p>Para realizar a gravação dos dados no banco de dados, após realizar os passos acima.</p>
<p>Criar uma classe com o método main e criar um EntityManagerFactory e durante a criação do EntityManagerFactory ele recebe o nome que você 
deu para seu arquivo de persistencia, no meu caso o nome foi escola (persistence-unit name="escola")</p>
<p>Realizar o inicio da transação getTransaction().begin()</p>
<p>Realizar a persistencia dos dados que você queria gravar no banco de dados persist(dados)</p>
<p>Se tudo ocorreu como você queria realizar o commit para validar a transação getTransaction().commit()</p>
<p>Importante! Sempre após a abertura da conexão com o banco de dados é necessário realizar o fechamento dessa transação close() </p>


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("escola");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(dados que você quer persist no banco);
		em.getTransaction().commit();
		
		em.close();
		