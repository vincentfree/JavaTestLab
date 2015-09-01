public class Resource implements AutoCloseable {
  @Override
  public void close() throws Exception {
    throw new Exception("Exception thrown from close()");
  }

  public void doWork() throws Exception {
    throw new Exception("Exception thrown from doWork()");
  }
}