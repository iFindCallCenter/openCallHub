package com.och.esl.handler.route;

import com.och.common.annotation.EslRouteName;
import com.och.common.domain.CallInfo;
import com.och.common.enums.RouteTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author danmo
 * @date 2023-11-10 17:20
 **/
@EslRouteName(RouteTypeEnum.SKILL_GROUP)
@Component
@Slf4j
public class FsSkillGroupRouteHandler extends FsAbstractRouteHandler {


    //    private Map<Long, PriorityQueue<CallQueue>> callQueueMap = new ConcurrentHashMap<>();
//
//    private ThreadPoolExecutor callAgentExecutor = new ThreadPoolExecutor(5, 10, 0L,
//            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new DefaultThreadFactory("fs-agent-distribution-pool-%d"));
//    /**
//     * 定时线程组
//     */
//    private static ScheduledExecutorService fsAcdThread = new ScheduledThreadPoolExecutor(1, new DefaultThreadFactory("fs-acd-pool-%d"));
//
//
    @Override
    public void handler(String address, CallInfo callInfo, String uniqueId, String routeValue) {
//        log.info("转技能组 callId:{} transfer to {}", callInfo.getCallId(), routeValue);
//        AjaxResult<LfsSkillVo> ajaxResult = lfsSkillClient.getSkillDetail(Long.valueOf(routeValue));
//        if (Objects.isNull(ajaxResult) || Objects.isNull(ajaxResult.getData())) {
//            log.info("转技能组获取技能组失败 callee:{}, skillId:{}", callInfo.getCallee(), routeValue);
//            fsClient.hangupCall(address, callInfo.getCallId(), uniqueId);
//            return;
//        }
//        LfsSkillVo skill = ajaxResult.getData();
//        callInfo.setSkillId(skill.getId());
//
//        //电话经过技能组
//        LfsCallInfoDetail detail = new LfsCallInfoDetail();
//        detail.setCallId(callInfo.getCallId());
//        detail.setCreateTime(DateUtil.current());
//        detail.setStartTime(DateUtil.current());
//        detail.setOrderNum(callInfo.getDetailList() == null ? 0 : callInfo.getDetailList().size() + 1);
//        detail.setTransferType(3);
//        detail.setAfterTime(skill.getAfterTime());
//        detail.setTransferId(callInfo.getSkillId());
//        callInfo.addDetailList(detail);
//
//
//        List<LfsSkillAgentRelVo> agentList = skill.getAgentList();
//        if (CollectionUtil.isEmpty(agentList)) {
//            log.info("转技能组未配置坐席失败 callee:{}, skillId:{}", callInfo.getCallee(), routeValue);
//            callInfo.setSkillHangUpReason(HangupCauseEnum.FULLBUSY.getDesc());
//            fsClient.hangupCall(address, callInfo.getCallId(), uniqueId);
//            return;
//        }
//        List<String> agentIds = agentList.stream().map(LfsSkillAgentRelVo::getAgentId).map(String::valueOf).toList();
//
//        List<LfsSipAgentStatusVo> lfsSipAgentStatusList = redisService.getMultiCacheMapValue(StringUtils.format(CacheConstants.AGENT_CURRENT_STATUS_KEY, callInfo.getTenantId()), agentIds);
//
//        List<LfsSipAgentStatusVo> freeAgentList = new LinkedList<>();
//
//        //获取空闲状态坐席列表
//        if (CollectionUtil.isNotEmpty(lfsSipAgentStatusList)) {
//            List<LfsSipAgentStatusVo> sipAgentStatusVoList = lfsSipAgentStatusList.stream()
//                    .filter(item -> Objects.equals(SipAgentStatusEnum.READY.getCode(), item.getStatus()))
//                    .toList();
//            freeAgentList.addAll(sipAgentStatusVoList);
//        }
//
//
//        //无空闲坐席
//        if (CollectionUtil.isEmpty(freeAgentList)) {
//            Integer fullBusyType = skill.getFullBusyType();
//            switch (fullBusyType) {
//                //排队
//                case 0:
//                    callQueueStrategy(address, callInfo, uniqueId, skill);
//                    break;
//                //溢出
//                case 1:
//                    overFlowStrategy(address, callInfo, uniqueId, skill);
//                    break;
//                //挂机
//                case 2:
//                    callInfo.setHangupDir(3);
//                    callInfo.setHangupCause(HangupCauseEnum.OVERFLOW.getCode());
//                    fsClient.hangupCall(address, callInfo.getCallId(), uniqueId);
//                    saveCallInfo(callInfo);
//                    break;
//                default:
//                    break;
//            }
//            return;
//        }
//
//        Map<Long, Integer> skillLevelMap = agentList.stream().collect(Collectors.toMap(LfsSkillAgentRelVo::getAgentId, LfsSkillAgentRelVo::getLevel, (key1, key2) -> key1));
//        freeAgentList.forEach(item -> item.setLevel(skillLevelMap.get(item.getId())));
//        //获取坐席策略
//        LfsSipAgentVo agentInfo = getAgentStrategy(callInfo, skill, freeAgentList);
//        if (Objects.isNull(agentInfo)) {
//            log.info("转技能组 获取空闲坐席失败 callee:{}, skillId:{}", callInfo.getCallee(), routeValue);
//            callInfo.setSkillHangUpReason(HangupCauseEnum.FULLBUSY.getDesc());
//            fsClient.hangupCall(address, callInfo.getCallId(), uniqueId);
//            return;
//        }
//        transferAgentHandler(address,agentInfo, callInfo, uniqueId);
//
    }
//
//    private void callQueueStrategy(String address, LfsCallInfo callInfo, String uniqueId, LfsSkillVo skill) {
//        PriorityQueue<CallQueue> callQueues = callQueueMap.get(callInfo.getSkillId());
//        if (callQueues == null) {
//            callQueues = new PriorityQueue<CallQueue>();
//        }
//        if(callQueues.size() >= skill.getQueueLength()){
//            overFlowStrategy(address, callInfo, uniqueId, skill);
//            return;
//        }
//        callInfo.setQueueStartTime(DateUtil.current());
//        if (callInfo.getFirstQueueTime() == null) {
//            callInfo.setFirstQueueTime(callInfo.getQueueStartTime());
//        }
//        callQueues.add(CallQueue.builder().callId(callInfo.getCallId())
//                .skillId(callInfo.getSkillId())
//                .address(address)
//                .type(1)
//                .startTime(callInfo.getQueueStartTime())
//                .uniqueId(uniqueId).build());
//        callQueueMap.put(callInfo.getSkillId(), callQueues);
//        saveCallInfo(callInfo);
//    }
//
//    private void overFlowStrategy(String address, LfsCallInfo callInfo, String uniqueId, LfsSkillVo skill) {
//        callInfo.setOverflowCount(callInfo.getOverflowCount() == null ? 0 : callInfo.getOverflowCount() + 1);
//        if (skill.getOverflowType() == 0) {
//            callInfo.setHangupDir(3);
//            callInfo.setHangupCause(HangupCauseEnum.FULLBUSY.getCode());
//            //坐席繁忙音
//            fsClient.playFile(address,uniqueId,"agentbusy.wav");
//            fsClient.hangupCall(address, callInfo.getCallId(), uniqueId);
//        } else if (skill.getOverflowType() == 1) {
//            //todo 转IVR
//        }
//        saveCallInfo(callInfo);
//    }
//
//
//    private LfsSipAgentVo getAgentStrategy(LfsCallInfo callInfo, LfsSkillVo skill, List<LfsSipAgentStatusVo> freeAgentList) {
//        switch (skill.getStrategyType()) {
//            //0-随机
//            case 0:
//                return RandomUtil.randomEle(freeAgentList);
//            //1-轮询
//            case 1:
//                String pollingKey = StringUtils.format(CacheConstants.CALL_SKILL_POLLING_KEY, callInfo.getTenantId(), skill.getId());
//                int pollingNum = redisService.keyIsExists(pollingKey) ? redisService.getCacheObject(pollingKey) : 0;
//                Integer nextPollingNum = findNextPollingNum(freeAgentList, pollingNum);
//                redisService.setCacheObject(StringUtils.format(CacheConstants.CALL_SKILL_POLLING_KEY, callInfo.getTenantId(), skill.getId()), nextPollingNum);
//                return freeAgentList.get(nextPollingNum);
//            //2-最长空闲时间
//            case 2:
//                return freeAgentList.stream().max(Comparator.comparing(item -> DateUtil.current() - item.getStatusTime())).orElse(null);
//            //3-当天最少应答次数
//            case 3:
//                return freeAgentList.stream().min(Comparator.comparing(LfsSipAgentStatusVo::getReceptionNum)).orElse(null);
//            //4-最长话后时长
//            case 4:
//                return freeAgentList.stream().min(Comparator.comparing(item -> DateUtil.current() - item.getCallEndTime())).orElse(null);
//            default:
//                return null;
//        }
//    }
//
//
//
//
//    //acd排队策略
//    private void fsAcd() {
//        try {
//            Set<Long> skillIds = callQueueMap.keySet();
//            List<CallQueue> queueList = callQueueMap.values().stream().flatMap(Collection::stream).toList();
//            if(CollectionUtil.isEmpty(skillIds) || CollectionUtil.isEmpty(queueList)){
//                return;
//            }
//            LfsSkillQuery skillQuery = new LfsSkillQuery();
//            skillQuery.setIds(new ArrayList<>(skillIds));
//            TableDataInfo<List<LfsSkillVo>> tableDataInfo = lfsSkillClient.getListByIds(skillQuery);
//            if(Objects.isNull(tableDataInfo) || CollectionUtil.isEmpty(tableDataInfo.getRows())){
//                return;
//            }
//            long current = DateUtil.current();
//            List<LfsSkillVo> lfsSkillList = tableDataInfo.getRows();
//            lfsSkillList.sort(Comparator.comparing(LfsSkillVo::getPriority));
//            for (LfsSkillVo skill : lfsSkillList) {
//                PriorityQueue<CallQueue> callQueues = callQueueMap.get(skill.getId());
//                Iterator<CallQueue> iterator = callQueues.iterator();
//                while (iterator.hasNext()){
//                    CallQueue callQueue = iterator.next();
//                    //正常排队超时
//                    if (current/1000 - callQueue.getStartTime()/1000 >= skill.getTimeOut()) {
//                        callAgentExecutor.execute(() -> {
//                            queueTimeout(callQueue);
//                        });
//                        iterator.remove();
//                        continue;
//                    }
//                    LfsCallInfo callInfo = lfsCallCacheService.getCallInfo(callQueue.getCallId());
//                    if (callInfo == null) {
//                        continue;
//                    }
//
//                    List<LfsSkillAgentRelVo> agentList = skill.getAgentList();
//                    List<String> agentIds = agentList.stream().map(LfsSkillAgentRelVo::getAgentId).map(String::valueOf).toList();
//
//                    List<LfsSipAgentStatusVo> lfsSipAgentStatusList = redisService.getMultiCacheMapValue(StringUtils.format(CacheConstants.AGENT_CURRENT_STATUS_KEY, callInfo.getTenantId()), agentIds);
//                    List<LfsSipAgentStatusVo> freeAgentList = new LinkedList<>();
//                    //获取空闲状态坐席列表
//                    if (CollectionUtil.isNotEmpty(lfsSipAgentStatusList)) {
//                        List<LfsSipAgentStatusVo> sipAgentStatusVoList = lfsSipAgentStatusList.stream()
//                                .filter(item -> Objects.equals(SipAgentStatusEnum.READY.getCode(), item.getStatus()))
//                                .toList();
//                        freeAgentList.addAll(sipAgentStatusVoList);
//                    }
//
//                    if(CollectionUtil.isEmpty(freeAgentList)){
//                        if (callQueue.getPlayFlag() == null || !callQueue.getPlayFlag()) {
//                            fsClient.playFile(callQueue.getAddress(), callQueue.getUniqueId(), "queue.wav");
//                            callQueue.setPlayFlag(true);
//                        }
//                        continue;
//                    }
//                    Map<Long, Integer> skillLevelMap = agentList.stream().collect(Collectors.toMap(LfsSkillAgentRelVo::getAgentId, LfsSkillAgentRelVo::getLevel, (key1, key2) -> key1));
//                    freeAgentList.forEach(item -> item.setLevel(skillLevelMap.get(item.getId())));
//
//                    LfsSipAgentVo agentInfo = getAgentStrategy(callInfo, skill, freeAgentList);
//                    if (Objects.isNull(agentInfo)) {
//                        log.info("转技能组 队列获取空闲坐席失败 callee:{}, skillId:{}", callInfo.getCallee(), skill.getId());
//                        if (!callQueue.getPlayFlag()) {
//                            fsClient.playFile(callQueue.getAddress(), callQueue.getUniqueId(), "queue.wav");
//                            callQueue.setPlayFlag(true);
//                        }
//                        continue;
//                    }
//                    //停止放音
//                    callAgentExecutor.execute(() -> {
//                        if (callQueue.getPlayFlag()) {
//                            fsClient.playBreak(callQueue.getAddress(), callQueue.getUniqueId());
//                        }
//                        callInfo.setQueueEndTime(current);
//                        //转坐席音
//                        fsClient.playFile(callQueue.getAddress(),callQueue.getUniqueId(),"agentbusy.wav");
//                        transferAgentHandler(callQueue.getAddress(),agentInfo, callInfo, callQueue.getUniqueId());
//                        iterator.remove();
//                    });
//                }
//                //callQueueMap.remove(skill.getId());
//            }
//        } catch (Exception e) {
//            log.error("排队异常",e);
//        }
//    }
//
//    private void transferAgentHandler(String address, LfsSipAgentVo agentInfo, LfsCallInfo callInfo, String uniqueId) {
//        String agentNumber = agentInfo.getAgentNumber();
//        String otherUniqueId = RandomUtil.randomNumbers(32);
//
//        if (StringUtils.isEmpty(agentNumber)) {
//            log.error("transferAgentHandler agent:{} 坐席未绑定SIP号码, callId:{}", agentInfo.getId(), callInfo.getCallId());
//            callInfo.setSkillHangUpReason(HangupCauseEnum.AGENT_NO_BAND_SIP.getDesc());
//            fsClient.hangupCall(address, callInfo.getCallId(), uniqueId);
//            return;
//        }
//        LfsCallRouteVo callRoute = lfsCallCacheService.getCallRoute(callInfo.getTenantId(), callInfo.getCallee(), 2);
//        if(Objects.isNull(callRoute)){
//            log.info("transferAgentHandler 未配置号码路由 callee:{}",agentNumber);
//            callInfo.setSkillHangUpReason(HangupCauseEnum.NOT_ROUTE.getDesc());
//            fsClient.hangupCall(address, callInfo.getCallId(), uniqueId);
//            return;
//        }
//        if(CollectionUtil.isEmpty(callRoute.getGatewayList())){
//            log.info("transferAgentHandler 号码路由未关联网关信息 callee:{}",agentNumber);
//            callInfo.setSkillHangUpReason(HangupCauseEnum.ROUTE_NOT_GATEWAY.getDesc());
//            fsClient.hangupCall(address, callInfo.getCallId(), uniqueId);
//            return;
//        }
//        callInfo.setAgentId(agentInfo.getId());
//        callInfo.setAgentNumber(agentInfo.getAgentNumber());
//        callInfo.setAgentName(agentInfo.getName());
//        callInfo.setCallee(agentInfo.getAgentNumber());
//        //构建主叫通道
//        LfsChannelInfo otherChannelInfo = LfsChannelInfo.builder().callId(callInfo.getCallId()).uniqueId(otherUniqueId).cdrType(2).type(2)
//                .agentId(agentInfo.getId()).agentNumber(agentInfo.getAgentNumber()).agentName(agentInfo.getName())
//                .callTime(DateUtil.current()).otherUniqueId(uniqueId)
//                .called(agentNumber).caller(callInfo.getCaller()).display(callInfo.getCallerDisplay()).build();
//        callInfo.setChannelInfoMap(otherUniqueId,otherChannelInfo);
//        callInfo.setProcess(ProcessEnum.CALL_BRIDGE);
//        lfsCallCacheService.saveCallInfo(callInfo);
//        lfsCallCacheService.saveCallRel(otherUniqueId,callInfo.getCallId());
//
//        //设置坐席通话中
//        try {
//            SecurityContextHolder.setTenantId(callInfo.getTenantId());
//            lfsAgentClient.checkCalling(agentInfo.getId(),new LfsSipAgentQuery());
//        } finally {
//            SecurityContextHolder.remove();
//        }
//
//        fsClient.makeCall(address,callInfo.getCallId(), callInfo.getCallee(),callInfo.getCallerDisplay(),otherUniqueId,callInfo.getCalleeTimeOut(), callRoute);
//
//        Boolean isAgent = redisService.getCacheMapHasKey(StringUtils.format(CacheConstants.AGENT_CURRENT_STATUS_KEY, callInfo.getTenantId()), String.valueOf(callInfo.getAgentId()));
//        if(isAgent){
//            LfsSipAgentStatusVo agentStatusVo = redisService.getCacheMapValue(StringUtils.format(CacheConstants.AGENT_CURRENT_STATUS_KEY, callInfo.getTenantId()), String.valueOf(callInfo.getAgentId()));
//            agentStatusVo.setReceptionNum(agentStatusVo.getReceptionNum() + 1);
//            redisService.setCacheMapValue(StringUtils.format(CacheConstants.AGENT_CURRENT_STATUS_KEY,callInfo.getTenantId()),String.valueOf(agentStatusVo.getId()),agentStatusVo);
//        }
//    }
//
//    /**
//     * 超时挂机
//     * @param callQueue
//     */
//    private void queueTimeout(CallQueue callQueue) {
//        fsClient.playBreak(callQueue.getAddress(), callQueue.getUniqueId());
//        Long current = DateUtil.current();
//        LfsCallInfo callInfo = lfsCallCacheService.getCallInfo(callQueue.getCallId());
//        if (callInfo == null) {
//            return;
//        }
//        callInfo.setQueueEndTime(current);
//        log.info("排队超时 callId:{} queueTimeout:{}", callQueue.getCallId(), callQueue.getStartTime());
//        //排队超时挂机
//        callInfo.setHangupDir(3);
//        callInfo.setHangupCause(HangupCauseEnum.QUEUE_TIME_OUT.getCode());
//        callInfo.setQueueEndTime(current);
//        if (!CollectionUtils.isEmpty(callInfo.getDetailList())) {
//            LfsCallInfoDetail callDetail = callInfo.getDetailList().get(callInfo.getDetailList().size() - 1);
//            if (callDetail != null) {
//                callDetail.setEndTime(current);
//            }
//        }
//        callInfo.setSkillHangUpReason(HangupCauseEnum.QUEUE_TIME_OUT.getDesc());
//
//        fsClient.hangupCall(callQueue.getAddress(), callQueue.getCallId(), callQueue.getUniqueId());
//        saveCallInfo(callInfo);
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        log.info("开启呼入队列扫描");
//        fsAcdThread.scheduleAtFixedRate(this::fsAcd, 5, 2, TimeUnit.SECONDS);
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        log.info("关闭呼入队列扫描");
//        fsAcdThread.shutdown();
//    }
//
//
//    /**
//     * 二分查询轮训级别
//     *
//     * @param freeAgentList
//     * @param pollingNum
//     * @return
//     */
//   private Integer findNextPollingNum(List<LfsSipAgentStatusVo> freeAgentList, int pollingNum) {
//        freeAgentList.sort(Comparator.comparing(LfsSipAgentStatusVo::getLevel));
//        int left = 0;
//        int right = freeAgentList.size() - 1;
//        if(pollingNum >= freeAgentList.get(right).getLevel()){
//            return freeAgentList.get(left).getLevel();
//        }
//        while (left < right) {
//            //防止整数溢出
//            int mid = (right - left) / 2 + left;
//            //如果当前元素比目标元素小或者相同 则去他右边找
//            if (freeAgentList.get(mid).getLevel() <= pollingNum) {
//                left = mid + 1;
//            } else {
//                //如果当前元素比目标元素大 则去他左边找 此时注意 应该包括其当前边界
//                right = mid;
//            }
//        }
//        return freeAgentList.get(left).getLevel();
//    }
}
