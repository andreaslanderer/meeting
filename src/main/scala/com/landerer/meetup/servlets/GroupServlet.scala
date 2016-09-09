package com.landerer.meetup.servlets

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

import com.landerer.meetup.domainObjects.Group
import com.landerer.meetup.services.GroupService

class GroupServlet extends HttpServlet {

  override def doGet(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    val groupName = request.getParameter("name")
    val group = GroupService.createGroup(groupName)
    responseWithGroup(response, group)
  }

  override def doPost(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    val groupId = request.getParameter("id")
    val group = GroupService.readGroupById(groupId)
    responseWithGroup(response, group)
  }

  def responseWithGroup(response: HttpServletResponse, group: Group): Unit = {
    val responseWriter = response.getWriter
    responseWriter.write(s"group id: '${group.id}', group name: '${group.name}'")
    responseWriter.flush()
  }
}