package freelifer.sdk.usage;

/**
 * @author kzhu on 2017/8/22.
 * @deprecated
 */
class BuildAction implements Action {
    @Override
    public boolean run(String[] args) {
        System.err.println("buildAction len " + args.length);
        if (args.length == 0) {
            return false;
        }
        for (String src : args) {
            System.err.println("buildAction: " + src);
        }
        return true;
    }
}
