public  class WebUtilities {

    public void threadSleep(int sleepTimeInSecond){
        try {
            Thread.sleep(sleepTimeInSecond);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
