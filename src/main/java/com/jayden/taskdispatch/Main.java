package com.jayden.taskdispatch;

import com.jayden.taskdispatch.domain.Task;
import com.jayden.taskdispatch.domain.TaskDispatchSolution;
import com.jayden.taskdispatch.domain.User;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author 孙勇军（089245）
 * @since 2019/11/30
 */
public class Main {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#0.00%");

    public static void main(String[] args) {
        TaskDispatchSolution taskDispatchSolution = new TaskDispatchSolution();
        init(taskDispatchSolution);
        Solver.calc(taskDispatchSolution);
        // Display the result
        System.out.println(toDisplayString(taskDispatchSolution));
    }

    private static void init(TaskDispatchSolution taskDispatchSolution) {
        taskDispatchSolution.setUserList(Arrays.asList(
                new User("u1", 2, 8, 1),
                new User("u2", 2, 8, 0),
                new User("u3", 2, 8, 0))
        );
        taskDispatchSolution.setTaskList(Arrays.asList(
                new Task(1, 1, 3),
                new Task(2, 3, 1))
        );
    }

    private static String toDisplayString(TaskDispatchSolution taskDispatchSolution) {
        StringBuilder displayString = new StringBuilder();
        for (User user : taskDispatchSolution.getUserList()) {
            displayString.append(user.getName()).append(" -> u:")
                    .append(user.getUsedTaskUnit()).append(", ")
                    .append(DECIMAL_FORMAT.format(user.getWorkPercent()))
                    .append(", [");
            for (Task task : user.getTaskList()) {
                displayString.append('t').append(task.getId()).append("(p:").append(task.getPriority()).append(",c:")
                        .append(task.getComplexity()).append("),");
            }
            if (displayString.charAt(displayString.length() - 1) == ',') {
                displayString.deleteCharAt(displayString.length() - 1);
            }
            displayString.append("]\n");
        }
        return displayString.toString();
    }
}
