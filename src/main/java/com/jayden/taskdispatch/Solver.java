package com.jayden.taskdispatch;

import com.jayden.taskdispatch.domain.Task;
import com.jayden.taskdispatch.domain.TaskDispatchSolution;
import com.jayden.taskdispatch.domain.User;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 孙勇军（089245）
 * @since 2019/11/30
 */
public class Solver {
    public static void calc(TaskDispatchSolution taskDispatchSolution) {
        List<Task> taskList = taskDispatchSolution.getTaskList();
        List<User> userList = taskDispatchSolution.getUserList();

        taskList.sort((o1, o2) -> Float.compare(o2.getPriority(), o1.getPriority()));
        for (Task task : taskList) {
            userList.sort((o1, o2) -> new CompareToBuilder().append(o1.getWorkPercent(), o2.getWorkPercent()).toComparison());
            printUserList(userList);
            Optional<User> optionalUser = userList.stream().filter(u -> u.getCurFreeTaskUnit() >= task.getConsumeTaskUnit()).findFirst();
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                task.setUser(user);
                user.addTask(task);
            }
            printUserList(userList);
        }
    }

    private static void printUserList(List<User> userList) {
        System.out.println(userList.stream().map(u -> String.format("%s-%d-%d-%f", u.getName(), u.getCurUsedTaskUnit(), u.getTaskUnitCapacity(), u.getWorkPercent()))
                .collect(Collectors.joining(", ")));
    }
}
