package com.landerer.meetup.services
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

import com.landerer.meetup.domainObjects.Group

/**
  * Created by andreaslanderer on 09/09/16.
  */
object GroupService {

  private val groups = new ConcurrentHashMap[String, Group]()

  def createGroup(groupName: String): Group = {
    val groupId = UUID.randomUUID().toString
    val group = Group(groupId, groupName)
    groups.put(groupId, group)
    group
  }

  def readGroupById(groupId: String) = {
    groups.get(groupId)
  }
}
