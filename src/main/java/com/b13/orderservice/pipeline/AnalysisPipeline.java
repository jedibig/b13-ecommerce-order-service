package com.b13.orderservice.pipeline;

import org.apache.camel.builder.RouteBuilder;

public class AnalysisPipeline extends RouteBuilder{
	


	@Override
	public void configure() throws Exception {

//		from("jdbc:dataSource").process(new Processor() {
//			public void process(Exchange xchg) throws Exception {
//			//Take the Employee object from the exchange and create the insert query
//				Employee employee = xchg.getIn().getBody(Employee.class);
//				String query = "INSERT INTO employee(empId,empName)values('" + employee.getEmpId() + "','"
//						+ employee.getEmpName() + "')";
//			// Set the insert query in body and call camel jdbc
//				xchg.getIn().setBody(query);
//			}
//		}).to("jdbc:dataSource");
	}
}
