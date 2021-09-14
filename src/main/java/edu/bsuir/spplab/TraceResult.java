package edu.bsuir.spplab;

public class TraceResult {
    private String methodName;
    private String className;
    private long methodExecutionTime;
    private long fullTimeOfMethodsExecution;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getMethodExecutionTime() {
        return methodExecutionTime;
    }

    public void setMethodExecutionTime(long methodExecutionTime) {
        this.methodExecutionTime = methodExecutionTime;
    }

    public long getFullTimeOfMethodsExecution() {
        return fullTimeOfMethodsExecution;
    }

    public void setFullTimeOfMethodsExecution(long fullTimeOfMethodsExecution) {
        this.fullTimeOfMethodsExecution = fullTimeOfMethodsExecution;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TraceResult{");
        sb.append("methodName='").append(methodName).append('\'');
        sb.append(", className='").append(className).append('\'');
        sb.append(", methodExecutionTime=").append(methodExecutionTime);
        sb.append(", fullTimeOfMethodsExecution=").append(fullTimeOfMethodsExecution);
        sb.append('}');
        return sb.toString();
    }
}
