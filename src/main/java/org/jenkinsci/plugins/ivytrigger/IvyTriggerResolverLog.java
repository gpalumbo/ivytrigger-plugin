package org.jenkinsci.plugins.ivytrigger;

import org.apache.ivy.util.AbstractMessageLogger;
import org.jenkinsci.lib.xtrigger.XTriggerLog;

/**
 * @author Gregory Boissinot
 */
public class IvyTriggerResolverLog extends AbstractMessageLogger {

    private XTriggerLog log;

    private boolean debug;

    public IvyTriggerResolverLog(XTriggerLog xTriggerLog, boolean debug) {
        this.log = xTriggerLog;
        this.debug = debug;
    }

    @Override
    protected void doProgress() {
        log.info(".");
    }

    @Override
    protected void doEndProgress(String msg) {
        if (msg != null && msg.length() != 0) {
            log.info(msg);
        }
    }

    public void log(String msg, int level) {
        if (msg != null && msg.length() != 0) {
            if (debug) {
                log.info(msg);
            }
        }
    }

    public void rawlog(String msg, int level) {
        if (msg != null && msg.length() != 0) {
            log.info(msg);
        }
    }
}
