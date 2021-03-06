package edu.cs524

import java.util.concurrent.ConcurrentLinkedQueue
import scala.collection.JavaConversions._


trait Worker extends NetworkNode{


  var master:Master = null
  var TaskQueue:ConcurrentLinkedQueue[Task] = new ConcurrentLinkedQueue[Task]()
  def SetMasterNode(m: Master) = master = m

  override def ShouldDoWork(): Boolean = TaskQueue.size() > 0

  var props:Map[String, Any] = Map()

  def setProperties(map: Map[String, Any]) = props = map

  def SubmitTask(task: Task)= TaskQueue.add(task)
  def SubmitTasks(tasks: Seq[Task]): Any = TaskQueue.addAll(tasks)
}
