package com.demetrius.projectFuji.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.demetrius.projetoFuji.model.Department;
import com.demetrius.projetoFuji.model.History;
import com.demetrius.projetoFuji.model.Person;
import com.demetrius.projetoFuji.model.Project;
import com.demetrius.projetoFuji.model.Task;
import com.demetrius.projetoFuji.repository.DepartmentRepository;
import com.demetrius.projetoFuji.repository.HistoryRepository;
import com.demetrius.projetoFuji.repository.PersonRepository;
import com.demetrius.projetoFuji.repository.ProjectRepository;
import com.demetrius.projetoFuji.repository.TaskRepository;



public class WebConfig
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private HistoryRepository historyRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskRepository taskRepository;

	SimpleDateFormat formatData = new SimpleDateFormat("dd-MM-yyyy");
	
	public void run(String... args) throws Exception
	{
		Person p1 =  new Person(null, "DEMETRIUS", "BRINGEL", "bringelcruz@gmail.com", "(83)91111-1111",formatData.parse("27-04-2020"));
		Person p2 =  new Person(null, "RODRIGO", "FUJIOKA", "fujioka@gmail.com", "(83)91111-1111",formatData.parse("27-04-2019"));
		Person p3 =  new Person(null, "GUILHERME", "LIMA", "guilhermelima@hotmail.com", "(81)91111-1111",formatData.parse("27-04-2018"));
		Person p4 =  new Person(null, "PEDRO", "HENRIQUE", "phenrique@outlook.com", "(81)91111-1111",formatData.parse("27-04-2017"));
		Person p5 =  new Person(null, "RAFAELLA", "MACHADO", "rafacm@gmail.com", "(83)91111-1111",formatData.parse("27-04-2016"));
		Person p6 =  new Person(null, "MATHEUS", "ALBUQUERQUE", "ml_albuquerque@gmail.com", "(81)91111-1111",formatData.parse("27-04-2015"));
		Person p7 =  new Person(null, "MELLINA", "MACHADO", "mellinacsm@hotmail.com", "(83)91111-1111",formatData.parse("27-04-2014"));
		Person p8 =  new Person(null, "CALEBE", "CORREIA", "calebe.correia@gmail.com", "(83)91111-1111",formatData.parse("27-04-2013"));
		Person p9 =  new Person(null, "GERALDO", "GUEDES", "gguedes@hotmail.com", "(81)91111-1111",formatData.parse("27-04-2012"));
		Person p10 =  new Person(null, "ITALO", "FERREIRA", "italof15@gmail.com", "(84)91111-1111",formatData.parse("27-04-2011"));
		personRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));
		
		
		Department dpt1 = new  Department(null,"Qualidade");
		Department dpt2 = new  Department(null,"Tecnologia");
		Department dpt3 = new  Department(null,"RE");
		Department dpt4 = new  Department(null,"Administração");
		Department dpt5 = new  Department(null,"Marketing");
		departmentRepository.saveAll(Arrays.asList(dpt1,dpt2,dpt3,dpt4,dpt5));
		
		
		dpt1.getPerson().add(p1);
		dpt1.getPerson().add(p2);
		dpt1.getPerson().add(p3);
		dpt1.getPerson().add(p4);
		dpt2.getPerson().add(p5);
		dpt2.getPerson().add(p6);
		dpt2.getPerson().add(p7);
		dpt3.getPerson().add(p8);
		dpt3.getPerson().add(p9);
		dpt3.getPerson().add(p10);
		departmentRepository.saveAll(Arrays.asList(dpt1,dpt2,dpt3,dpt4,dpt5));
		
		
		Project pj1 = new Project(null, "Project 1", 1000, 2000, p1);
		Project pj2 = new Project(null, "Project 2", 2000, 3000, p2);
		Project pj3 = new Project(null, "Project 3", 3000, 4000, p3);
		Project pj4 = new Project(null, "Project 4", 5000, 6000, p4);
		Project pj5= new Project(null, "Project 5", 7000, 8000, p5);
		Project pj6 = new Project(null, "Project 6", 8000, 9000, p6);
		Project pj7 = new Project(null, "Project 7", 10000, 11000, p7);
		Project pj8 = new Project(null, "Project 8", 11000, 12000, p8);
		Project pj9 = new Project(null, "Project 9", 12000, 13000, p9);
		Project pj10 = new Project(null, "Project 10", 13000, 14000, p10);
		projectRepository.saveAll(Arrays.asList(pj1,pj2,pj3,pj4,pj5,pj6,pj7,pj8,pj9,pj10));
		
		
		p1.getProjeto().add(pj1);
		p2.getProjeto().add(pj2);
		p3.getProjeto().add(pj3);
		p4.getProjeto().add(pj4);
		p5.getProjeto().add(pj5);
		p6.getProjeto().add(pj6);
		p7.getProjeto().add(pj7);
		p8.getProjeto().add(pj8);
		p9.getProjeto().add(pj9);
		p10.getProjeto().add(pj10);
		personRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));
		
		
		Task tk1 = new Task(null,"Task 1","Description 1",100,formatData.parse("13-04-2020"),null,1);
		Task tk2 = new Task(null,"Task 2","Description 2",90,formatData.parse("13-04-2020"),formatData.parse("27-04-2020"),2);		
		Task tk3 = new Task(null,"Task 3","Description 3",80,formatData.parse("13-04-2020"),null,1);
		Task tk4 = new Task(null,"Task 4","Description 4",70,formatData.parse("13-04-2020"),null,1);
		Task tk5 = new Task(null,"Task 5","Description 5",60,formatData.parse("13-04-2020"),formatData.parse("27-04-2020"),2);
		Task tk6 = new Task(null,"Task 6","Description 6",50,formatData.parse("13-04-2020"),null,1);;
		Task tk7 = new Task(null,"Task 7","Description 7",40,formatData.parse("13-04-2020"),formatData.parse("27-04-2020"),2);
		Task tk8 = new Task(null,"Task 8","Description 8",30,formatData.parse("13-04-2020"),null,1);
		Task tk9 = new Task(null,"Task 9","Description 9",20,formatData.parse("13-04-2020"),formatData.parse("27-04-2020"),2);
		Task tk10 = new Task(null,"Task 10","Description 10",10,formatData.parse("13-04-2020"),null,1);
		taskRepository.saveAll(Arrays.asList(tk1,tk2,tk3,tk4,tk5,tk6,tk7,tk8,tk9,tk10));
		
		
		pj1.getTask().add(tk1);
		pj2.getTask().add(tk2);
		pj3.getTask().add(tk3);
		pj4.getTask().add(tk4);
		pj5.getTask().add(tk5);
		pj6.getTask().add(tk6);
		pj7.getTask().add(tk7);
		pj8.getTask().add(tk8);
		pj9.getTask().add(tk9);
		pj10.getTask().add(tk10);
		projectRepository.saveAll(Arrays.asList(pj1,pj2,pj3,pj4,pj5,pj6,pj7,pj8,pj9,pj10));
		
		History  ph1 = new History(null, tk1.getStartDate(), tk1.getEndDate(), pj1.getPerson(), dpt4, pj1);
		History  ph2 = new History(null, tk2.getStartDate(), tk2.getEndDate(), pj2.getPerson(), dpt3, pj2);
		History  ph3 = new History(null, tk3.getStartDate(), tk3.getEndDate(), pj3.getPerson(), dpt5, pj3);
		History  ph4 = new History(null, tk4.getStartDate(), tk4.getEndDate(), pj4.getPerson(), dpt2, pj4);
		History  ph5 = new History(null, tk5.getStartDate(), tk5.getEndDate(), pj5.getPerson(), dpt1, pj5);
		History  ph6 = new History(null, tk6.getStartDate(), tk6.getEndDate(), pj6.getPerson(), dpt5, pj6);
		History  ph7 = new History(null, tk7.getStartDate(), tk7.getEndDate(), pj7.getPerson(), dpt3, pj7);
		History  ph8 = new History(null, tk9.getStartDate(), tk8.getEndDate(), pj8.getPerson(), dpt2, pj8);
		History  ph9 = new History(null, tk8.getStartDate(), tk9.getEndDate(), pj9.getPerson(), dpt4, pj9);
		History  ph10 = new History(null, tk10.getStartDate(), tk10.getEndDate(), pj10.getPerson(), dpt3, pj10);
		historyRepository.saveAll(Arrays.asList(ph1,ph2,ph3,ph4,ph5));
	}
}
