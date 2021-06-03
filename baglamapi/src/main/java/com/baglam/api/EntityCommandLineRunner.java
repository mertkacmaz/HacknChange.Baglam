package com.baglam.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.baglam.api.entity.Employee;
import com.baglam.api.entity.Position;
import com.baglam.api.entity.Project;
import com.baglam.api.entity.Skill;
import com.baglam.api.repository.EmployeeRepository;
import com.baglam.api.repository.PositionRepository;
import com.baglam.api.repository.ProjectRepository;
import com.baglam.api.repository.SkillRepository;

@Component
public class EntityCommandLineRunner implements CommandLineRunner {

	@Autowired
	SkillRepository skillRepository;

	@Autowired
	PositionRepository positionRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	private List<String> skillNames = Arrays.asList("JAVA", "C#", "C++", "Phyton", ".NET", "AI", "Selenium", "Docker", "Spring Boot");
	private List<String> positionNames = Arrays.asList("Project Manager", "Software Developer", "Tester", "Quality Engineer", "Analyst", "Team Leader");
	private List<String> employeeNames = Arrays.asList("Orkun", "Mert", "Ilayda", "Suleyman", "Caner", "Selen", "Dilek", "Can", "Ibrahim");
	private List<String> projectNames = Arrays.asList("Diyalog", "H-ARF", "Drive", "İleti", "GIS", "ADVENT", "KASIF");

	@Override
	public void run(String... args) throws Exception {
		List<Skill> skills = new ArrayList<Skill>();
		List<String> programmingLanguages = new ArrayList<String>(skillNames);
		for (int i = 1; i < 6; i++) {
			for (String lang : programmingLanguages) {
				Skill skill = new Skill(lang, i);
				skillRepository.save(skill);
				skills.add(skill);
			}
			
		}

		List<Position> positions = new ArrayList<Position>();
		for (String pos : positionNames) {
			Position position = new Position(pos);
			positionRepository.save(position);
			positions.add(position);
		}

		List<Employee> employees = new ArrayList<Employee>();
		for (String name : employeeNames) {
			Random random = new Random();
			Employee employee = new Employee(name, random.nextInt(100));
			employee.setPosition(positions.get(random.nextInt(positions.size())));
			int skillCount = random.nextInt(10);
			for (int i = 0; i < Math.max(skillCount, 6); i++) {
				employee.add(skills.get(random.nextInt(skills.size())));
			}
			employeeRepository.save(employee);
			employees.add(employee);
		}

		List<Project> projects = new ArrayList<Project>();
		for (String name : projectNames) {
			Random random = new Random();
			Project project = new Project(name, ThreadLocalRandom.current().nextLong(System.currentTimeMillis(), System.currentTimeMillis() + 10000000l), false);
			int skillCount = random.nextInt(10);
			for (int i = 0; i < Math.max(skillCount, 6); i++) {
				project.add(skills.get(random.nextInt(skills.size())));
			}
			int employeeCount = random.nextInt(10);
			for (int i = 0; i < Math.max(employeeCount, 6); i++) {
				project.add(employees.get(random.nextInt(employees.size())));
			}
			projectRepository.save(project);
			projects.add(project);
		}
	}

}
