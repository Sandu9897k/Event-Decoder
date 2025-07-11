package com.altria.dialog.utils;

import com.altria.dialog.decoders.common.ConversionHelper;
import com.altria.dialog.decoders.ericsson.FilenameTimeInfo;
import com.altria.dialog.decoders.ericsson.LocationPart;
import com.altria.dialog.decoders.ericsson.MergedCSVDecoderInput;
import com.altria.dialog.parsers.kaitai.ericsson.EricssonEventFile;
import com.altria.dialog.parsers.proto.ericsson.EricssonPmEventOuterClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EricssonCsvWriterUtil {

    public String writeEricssonCsv4g(long eventId, EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        switch ((int) eventId) {
            case 3112:
                return write_event_3112_loc(eventRecord, decoderInput, filenameTimeInfo);
            case 3108:
                return write_event_3108_ta(eventRecord, decoderInput, filenameTimeInfo);
            case 3115:
                return write_event_3115_erab(eventRecord, decoderInput, filenameTimeInfo);
            case 3116:
                return write_event_3116_mdt5(eventRecord, decoderInput, filenameTimeInfo);
            case 3114:
                return write_event_3114_mdt3(eventRecord, decoderInput, filenameTimeInfo);
            case 3076:
                return write_event_3076_ue_traffic(eventRecord, decoderInput, filenameTimeInfo);
            case 3075:
                return write_event_3075_ue_radio_meas(eventRecord, decoderInput, filenameTimeInfo);
            case 3130:
                return write_event_3130_mdt6_dl(eventRecord, decoderInput, filenameTimeInfo);
            case 3129:
                return write_event_3129_mdt6_ul(eventRecord, decoderInput, filenameTimeInfo);
            case 3131:
                return write_event_3131_mdt7(eventRecord, decoderInput, filenameTimeInfo);
            case 3113:
                return write_event_3113_mdt5(eventRecord, decoderInput, filenameTimeInfo);
            case 4099:
                return write_event_4099_erab_setup(eventRecord, decoderInput, filenameTimeInfo);
            case 4112:
                return write_event_4112_proc_ho_exec_x2_out(eventRecord, decoderInput, filenameTimeInfo);
            case 4110:
                return write_event_4110_proc_ho_prep_x2_out(eventRecord, decoderInput, filenameTimeInfo);
            case 4106:
                return write_event_4106_proc_initial_ctxt_setup(eventRecord, decoderInput, filenameTimeInfo);
            case 4097:
                return write_event_4097_proc_rrc_conn_setup(eventRecord, decoderInput, filenameTimeInfo);
            case 4121:
                return write_event_4121_proc_rrc_connection_re_establishment(eventRecord, decoderInput, filenameTimeInfo);
            case 4125:
                return write_event_4125_proc_ue_ctxt_release(eventRecord, decoderInput, filenameTimeInfo);
            case 26:
                return write_event_26_rrc_ue_information_response(eventRecord, decoderInput, filenameTimeInfo);
            case 5269:
                return write_event_5269_ue_meas_geran1(eventRecord, decoderInput, filenameTimeInfo);
            case 5267:
                return write_event_5267_ue_meas_interfreq1(eventRecord, decoderInput, filenameTimeInfo);
            case 5153:
                return write_event_5153_ue_meas_intrafreq1(eventRecord, decoderInput, filenameTimeInfo);
            case 4104:
                return write_event_4104_proc_ho_exec_s1_out(eventRecord, decoderInput, filenameTimeInfo);
            case 5:
                return write_event_5_rrc_rrc_connection_release(eventRecord, decoderInput, filenameTimeInfo);
            case 8:
                return write_event_8_rrc_rrc_connection_reconfiguration(eventRecord, decoderInput, filenameTimeInfo);
            case 4114:
                return write_event_4114_proc_erab_release(eventRecord, decoderInput, filenameTimeInfo);
            default:
                return null;
        }
    }

    public String writeEricssonCsv5g(long eventId, EricssonPmEventOuterClass.PmEvent eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) throws InvalidProtocolBufferException, JsonProcessingException {
        switch ((int) eventId) {
            case 3349:
                return write_event_5g_3349_cu_cp_per_ue_puem_endc_report(eventRecord, decoderInput, filenameTimeInfo);
            case 3231:
                return write_event_5g_3231_cu_cp_per_ue_mdt_m6_ul_report(eventRecord, decoderInput, filenameTimeInfo);
            case 3230:
                return write_event_5g_3230_cu_cp_per_ue_mdt_report(eventRecord, decoderInput, filenameTimeInfo);
            default:
                return null;
        }
    }

    private String write_event_5g_3230_cu_cp_per_ue_mdt_report(EricssonPmEventOuterClass.PmEvent eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) throws InvalidProtocolBufferException, JsonProcessingException {
        EricssonPmEventOuterClass.CuCpFunctionPmEvent cucp = EricssonPmEventOuterClass.CuCpFunctionPmEvent.parseFrom(eventRecord.getPayload());
        StringBuilder b = new StringBuilder();
        if (eventRecord.getEventId() == 3230 && cucp.hasCucpPerUeMdtReport()) {
            append5gHeader(b, eventRecord.getHeader());
            EricssonPmEventOuterClass.CuCpPerUeMdtReport param = cucp.getCucpPerUeMdtReport();

            b.append(Objects.toString(param.getMainPlmnId(), "")).append(",");
            b.append(Objects.toString(param.getGnbId(), "")).append(",");
            if (param.hasAsn1()) {
                appendAsn1(param.getAsn1(), b);
            } else {
                b.append(",,,");
            }

            b.append(Objects.toString(param.getNci(), "")).append(",");
            b.append(Objects.toString(param.getGnbIdLength(), "")).append(",");

            if (param.hasGlobalGnbId()) {
                appendGlobalGnbId(param.getGlobalGnbId(), b);
            } else {
                b.append(",,");
            }

            b.append(Objects.toString(param.getReportType(), "")).append(",");
            b.append(Objects.toString(param.getTriggeringEvent(), "")).append(",");

            if (param.hasMenbId()) {
                appendMenbId(param.getMenbId(), b);
            } else {
                b.append(",,");
            }

            b.append(Objects.toString(param.getMenbCellId(), "")).append(",");
            b.append(Objects.toString(param.getServingPlmnId(), "")).append(",");
            b.append(Objects.toString(param.getMeasuredFrequency(), "")).append(",");
            b.append(Objects.toString(param.getNrType(), "")).append(",");
            b.append(Objects.toString(param.getMeasuredFrequencySubcarrierSpacing(), "")).append(",");
        }
        return b.toString();
    }

    private void appendMenbId(EricssonPmEventOuterClass.GlobalEnbId menbId, StringBuilder b) {
        b.append(Objects.toString(menbId.getPlmnIdentity(), "")).append(",");
        b.append(Objects.toString(menbId.getEnbId(), "")).append(",");
    }

    private void appendAsn1(EricssonPmEventOuterClass.Asn1Message asn1, StringBuilder b) throws JsonProcessingException {
        b.append(Objects.toString(asn1.getMsgDirection(), "")).append(",");
        b.append(Objects.toString(asn1.getMsgContent(), "")).append(",");

        String protocolNameString = ProtocolNameListToJsonArray(asn1.getProtocolNameList());
        b.append("\"").append(protocolNameString).append("\"").append(",");
    }

    public static String ProtocolNameListToJsonArray(List<EricssonPmEventOuterClass.ProtocolName> list) {
        return list.stream()
                .map(pn -> String.format("\"%s\"", pn.name()))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private String write_event_5g_3231_cu_cp_per_ue_mdt_m6_ul_report(EricssonPmEventOuterClass.PmEvent eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) throws InvalidProtocolBufferException, JsonProcessingException {
        EricssonPmEventOuterClass.CuCpFunctionPmEvent cucp = EricssonPmEventOuterClass.CuCpFunctionPmEvent.parseFrom(eventRecord.getPayload());
        StringBuilder b = new StringBuilder();
        if (eventRecord.getEventId() == 3231 && cucp.hasCucpM6UlReport()) {
            append5gHeader(b, eventRecord.getHeader());
            EricssonPmEventOuterClass.CuCpPerUeMdtM6UlReport param = cucp.getCucpM6UlReport();

            b.append(Objects.toString(param.getMainPlmnId(), "")).append(",");
            b.append(Objects.toString(param.getGnbId(), "")).append(",");
            b.append(Objects.toString(param.getNci(), "")).append(",");
            b.append(Objects.toString(param.getGnbIdLength(), "")).append(",");

            if (param.hasGlobalGnbId()) {
                appendGlobalGnbId(param.getGlobalGnbId(), b);
            } else {
                b.append(",,");
            }

            String mdtM6UlPacketDelayMeasurementListJString = mdtM6UlPacketDelayMeasurementListToJsonArray(param.getMdtM6UlPacketDelayMeasurementListList());
            b.append("\"").append(mdtM6UlPacketDelayMeasurementListJString).append("\"").append(",");

            if (param.hasMenbId()) {
                appendMenbId(param.getMenbId(), b);
            } else {
                b.append(",,");
            }

            b.append(Objects.toString(param.getMenbCellId(), "")).append(",");
            b.append(Objects.toString(param.getServingPlmnId(), "")).append(",");
            b.append(Objects.toString(param.getNrType(), "")).append(",");
        }
        return b.toString();
    }

    private String mdtM6UlPacketDelayMeasurementListToJsonArray(List<EricssonPmEventOuterClass.MdtM6UlPacketDelayMeasurements> list) {
        return list.stream()
                .map(m -> String.format(
                        "\"averagePacketDelayUl\": %d, {\"drbId\": %d, \"qosValue\": %d}",
                        m.getAveragePacketDelayUl(),
                        m.getDrbId(),
                        m.getQosValue()
                ))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private String write_event_5g_3349_cu_cp_per_ue_puem_endc_report(EricssonPmEventOuterClass.PmEvent eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) throws InvalidProtocolBufferException, JsonProcessingException {

        EricssonPmEventOuterClass.CuCpFunctionPmEvent cucp = EricssonPmEventOuterClass.CuCpFunctionPmEvent.parseFrom(eventRecord.getPayload());
        StringBuilder b = new StringBuilder();
        if (eventRecord.getEventId() == 3349 && cucp.hasCucpPuemEndcReport()) {

            append5gHeader(b, eventRecord.getHeader());
            EricssonPmEventOuterClass.CuCpPerUePuemEndcReport param = cucp.getCucpPuemEndcReport();

            b.append(Objects.toString(param.getMainPlmnId(), "")).append(",");
            b.append(Objects.toString(param.getGnbId(), "")).append(",");
            b.append(Objects.toString(param.getGnbIdLength(), "")).append(",");

            if (param.hasGlobalGnbId()) {
                appendGlobalGnbId(param.getGlobalGnbId(), b);
            } else {
                b.append(",,");
            }

            b.append(Objects.toString(param.getNci(), "")).append(",");
            b.append(Objects.toString(param.getServingPlmnId(), "")).append(",");

            if (param.hasPcellEcgi()) {
                appendEutraCgi(param.getPcellEcgi(), b);
            } else {
                b.append(",,");
            }

            b.append(Objects.toString(param.getPrefUeGroupId(), "")).append(",");
            b.append(Objects.toString(param.getUeGroupId(), "")).append(",");
            b.append(Objects.toString(param.getUeMobilityGroupId(), "")).append(",");
            b.append(Objects.toString(param.getUeServiceGroupId(), "")).append(",");
            b.append(Objects.toString(param.getUeAdmissionGroupId(), "")).append(",");
            b.append(Objects.toString(param.getMeasuredFrequency(), "")).append(",");
            b.append(Objects.toString(param.getMeasuredFrequencySubcarrierSpacing(), "")).append(",");
            b.append(Objects.toString(param.getMeasurementCount(), "")).append(",");

            if (param.hasMeasResultPsCell()) {
                appendMeasResultPsCell(param.getMeasResultPsCell(), b);
            } else {
                b.append(",,,,,");
            }

            String measResultServingMoListString = MeasResultServingMoListToJsonArray(param.getMeasResultServingMoListList());
            b.append("\"").append(measResultServingMoListString).append("\"").append(",");

            String MeasResultNr = MeasResultNrListToJsonArray(param.getMeasResultNeighCellsNrListList());
            String csvSafeJson = MeasResultNr.replace("\"", "\"\"");
            b.append("\"").append(csvSafeJson).append("\"").append(",");

        }
        return b.toString();
    }


    private void appendMeasResultPsCell(EricssonPmEventOuterClass.MeasResultPsCell measResultPsCell, StringBuilder b) throws JsonProcessingException {
        b.append(Objects.toString(measResultPsCell.getPhysCellId(), "")).append(",");
        if (measResultPsCell.hasCellResults()) {
            b.append(Objects.toString(measResultPsCell.getCellResults().getResultsSsbCell().getRsrp(), "")).append(",");
            b.append(Objects.toString(measResultPsCell.getCellResults().getResultsSsbCell().getRsrq(), "")).append(",");
            b.append(Objects.toString(measResultPsCell.getCellResults().getResultsSsbCell().getSinr(), "")).append(",");
        } else {
            b.append(",,,");
        }

        String rsIndexResults = RsIndexResultsListToJsonArray(measResultPsCell.getRsIndexResultsListList());
        String safeCsvValue = rsIndexResults.replace("\"", "\"\"");
        b.append("\"").append(safeCsvValue).append("\"").append(",");

    }

    public static String MeasResultServingMoListToJsonArray(List<EricssonPmEventOuterClass.MeasResultServingMo> list) {
        return list.stream().map(mo -> {
            StringBuilder json = new StringBuilder();
            json.append("{");

            json.append("\"servCellId\": ").append(mo.getServCellId());

            if (mo.hasMeasResultServingCell()) {
                String servingCellJson = MeasResultNrToJson(mo.getMeasResultServingCell());
                json.append(", \"measResultServingCell\": ").append(servingCellJson);
            }

            if (mo.hasMeasResultBestNeighCell()) {
                String bestNeighJson = MeasResultNrToJson(mo.getMeasResultBestNeighCell());
                json.append(", \"measResultBestNeighCell\": ").append(bestNeighJson);
            }

            json.append("}");
            return json.toString();
        }).collect(Collectors.joining(", ", "[", "]"));
    }



    public static String MeasResultNrToJson(EricssonPmEventOuterClass.MeasResultNr mr) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        json.append("\"physCellId\": ").append(mr.getPhysCellId());

        if (mr.hasNcgi()) {
            EricssonPmEventOuterClass.NrCgi ncgi = mr.getNcgi();
            json.append(", \"ncgi\": {");
            json.append("\"plmnIdentity\": \"").append(ncgi.getPlmnIdentity()).append("\"");
            json.append(", \"nrCellIdentity\": ").append(ncgi.getNrCellIdentity());
            json.append("}");
        }

        if (mr.hasCellResults() && mr.getCellResults().hasResultsSsbCell()) {
            EricssonPmEventOuterClass.MeasQuantityResults ssb = mr.getCellResults().getResultsSsbCell();
            json.append(", \"cellResults\": {\"resultsSsbCell\": {");
            json.append("\"rsrp\": ").append(ssb.getRsrp()).append(", ");
            json.append("\"rsrq\": ").append(ssb.getRsrq()).append(", ");
            json.append("\"sinr\": ").append(ssb.getSinr());
            json.append("}}");
        }

        if (!mr.getRsIndexResultsListList().isEmpty()) {
            json.append(", \"rsIndexResultsList\": ");
            json.append(RsIndexResultsListToJsonArray(mr.getRsIndexResultsListList()));
        }

        json.append(", \"gnbIdLength\": ").append(mr.getGnbIdLength());

        json.append("}");
        return json.toString();
    }


    public static String RsIndexResultsListToJsonArray(List<EricssonPmEventOuterClass.RsIndexResults> rsList) {
        return rsList.stream()
                .map(rs -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("{");

                    sb.append("\"ssbIndex\": ").append(rs.getSsbIndex());

                    if (rs.hasSsbResults()) {
                        EricssonPmEventOuterClass.MeasQuantityResults ssb = rs.getSsbResults();
                        sb.append(", \"ssbResults\": {");
                        sb.append("\"rsrp\": ").append(ssb.getRsrp()).append(", ");
                        sb.append("\"rsrq\": ").append(ssb.getRsrq()).append(", ");
                        sb.append("\"sinr\": ").append(ssb.getSinr());
                        sb.append("}");
                    }

                    sb.append("}");
                    return sb.toString();
                })
                .collect(Collectors.joining(", ", "[", "]"));
    }


    public static String MeasResultNrListToJsonArray(List<EricssonPmEventOuterClass.MeasResultNr> list) {
        return list.stream()
                .map(EricssonCsvWriterUtil::MeasResultNrToJson)
                .collect(Collectors.joining(", ", "[", "]"));
    }


    private void appendEutraCgi(EricssonPmEventOuterClass.EutraCgi pcellEcgi, StringBuilder b) {
        b.append(Objects.toString(pcellEcgi.getPlmnIdentity(), "")).append(",");
        b.append(Objects.toString(pcellEcgi.getCellIdentity(), "")).append(",");
    }

    private void appendGlobalGnbId(EricssonPmEventOuterClass.GlobalGnbId globalGnbId, StringBuilder b) {
        b.append(Objects.toString(globalGnbId.getPlmnIdentity(), "")).append(",");
        b.append(Objects.toString(globalGnbId.getGnbId(), "")).append(",");
    }

    private void append5gHeader(StringBuilder b, EricssonPmEventOuterClass.PmEventHeader header) throws JsonProcessingException {
        b.append(Objects.toString(header.getTimeStamp(), "")).append(",");
        b.append(Objects.toString(header.getSystemUuid(), "")).append(",");
        b.append(Objects.toString(header.getComputeName(), "")).append(",");
        b.append(Objects.toString(header.getNetworkManagedElement(), "")).append(",");

        String pmEventJobIdsString = LongListToJsonArray(header.getPmEventJobIdsList());
        b.append("\"").append(pmEventJobIdsString).append("\"").append(",");

        b.append(Objects.toString(header.getTraceReference(), "")).append(",");
        b.append(Objects.toString(header.getTraceRecordingSessionReference(), "")).append(",");
    }

    public static String LongListToJsonArray(List<Long> list) {

        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }


    private String write_event_4114_proc_erab_release(EricssonEventFile.TEventRecord
                                                              eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent4114Body body = eventRecord.event4114Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.triggeringNode(), "")).append(",");
        b.append(Objects.toString(body.s1ReleaseCause(), "")).append(",");
        b.append(Objects.toString(body.internalReleaseCause(), "")).append(",");
        b.append(Objects.toString(body.erabReleaseResult(), "")).append(",");

        appendIntInfo(b, body.erabDataLost());
        appendIntInfo(b, body.erabReleaseReqQci());

        b.append(Objects.toString(body.erabReleaseReqBitmap(), "")).append(",");
        b.append(Objects.toString(body.erabReleaseReq(), "")).append(",");

        appendIntInfo(b, body.erabReleaseReq3gppCauseGroup());
        appendIntInfo(b, body.erabReleaseReq3gppCause());
        appendIntInfo(b, body.erabReleaseSucc());
        appendIntInfo(b, body.erabReleaseFailure3gppCauseGroup());
        appendIntInfo(b, body.erabReleaseFailure3gppCause());
        appendIntInfo(b, body.erabSetupReqArp());
        appendIntInfo(b, body.erabSetupReqPci());
        appendIntInfo(b, body.erabSetupReqPvi());

        appendTimestamp(b, body.timestampStartHour(), body.timestampStartMinute(), body.timestampStartSecond(), body.timestampStartMillisec());
        appendTimestamp(b, body.timestampStopHour(), body.timestampStopMinute(), body.timestampStopSecond(), body.timestampStopMillisec());

        appendIntInfo(b, body.erabReleaseSuccGbr());
        appendIntInfo(b, body.erabInactiveGap());

        b.append(Objects.toString(body.tac(), "")).append(",");
        b.append(Objects.toString(body.svn(), "")).append(",");
        b.append(Objects.toString(body.maskedsrn(), "")).append(",");
        b.append(Objects.toString(body.erabReleaseReqBitmap2(), "")).append(",");
        b.append(Objects.toString(body.plmnIndex(), "")).append(",");
        b.append(Objects.toString(body.ueCategoryFlex(), "")).append(",");
        b.append(Objects.toString(body.spidValue(), "")).append(",");
        b.append(Objects.toString(body.uePowerClass(), "")).append(",");
        b.append(Objects.toString(body.brCeLevel(), "")).append(",");
        b.append(Objects.toString(body.subscriberGroupId(), "")).append(",");
        b.append(Objects.toString(body.ueEndcStage(), "")).append(",");

        return b.toString();

    }

    private String write_event_8_rrc_rrc_connection_reconfiguration(EricssonEventFile.TEventRecord
                                                                            eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent8Body body = eventRecord.event8Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.messageDirection(), "")).append(",");
        b.append(Objects.toString(body.l3messageLength(), "")).append(",");
        b.append(Objects.toString(body.l3messageContents(), "")).append(",");
        b.append(Objects.toString(body.crnti(), "")).append(",");

        return b.toString();
    }

    private String write_event_5_rrc_rrc_connection_release(EricssonEventFile.TEventRecord
                                                                    eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent5Body body = eventRecord.event5Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.messageDirection(), "")).append(",");
        b.append(Objects.toString(body.l3messageLength(), "")).append(",");
        b.append(Objects.toString(body.l3messageContents(), "")).append(",");
        b.append(Objects.toString(body.crnti(), "")).append(",");
        b.append(Objects.toString(body.immciValidity(), "")).append(",");

        return b.toString();

    }

    private String write_event_4104_proc_ho_exec_s1_out(EricssonEventFile.TEventRecord
                                                                eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent4104Body body = eventRecord.event4104Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.hoSourceOrTargetType(), "")).append(",");
        b.append(Objects.toString(body.hoTargetSelectionType(), "")).append(",");
        b.append(Objects.toString(body.neighborCgi(), "")).append(",");
        b.append(Objects.toString(body.procHoExecOutResult(), "")).append(",");
        b.append(Objects.toString(body.drxConfigIndex(), "")).append(",");
        b.append(Objects.toString(body.hoOutExecErabReqBitmap(), "")).append(",");
        b.append(Objects.toString(body.hoOutExecErabFailBitmap(), "")).append(",");
        b.append(Objects.toString(body.procHoExecOutAttemptCause(), "")).append(",");

        appendIntInfo(b, body.erabHoExecOutQci());

        appendTimestamp(b, body.timestampStartHour(), body.timestampStartMinute(), body.timestampStartSecond(), body.timestampStartMillisec());
        appendTimestamp(b, body.timestampStopHour(), body.timestampStopMinute(), body.timestampStopSecond(), body.timestampStopMillisec());

        b.append(Objects.toString(body.ta(), "")).append(",");
        b.append(Objects.toString(body.neighborPci(), "")).append(",");
        b.append(Objects.toString(body.triggerQuantity(), "")).append(",");
        b.append(Objects.toString(body.tac(), "")).append(",");
        b.append(Objects.toString(body.svn(), "")).append(",");
        b.append(Objects.toString(body.maskedsrn(), "")).append(",");
        b.append(Objects.toString(body.srvccType(), "")).append(",");

        b.append(Objects.toString(body.cgiMeasMethodType(), "")).append(",");
        b.append(Objects.toString(body.startCgiMeasQci1(), "")).append(",");
        b.append(Objects.toString(body.hoAfterResync(), "")).append(",");
        b.append(Objects.toString(body.hoOutExecErabReqBitmap2(), "")).append(",");
        b.append(Objects.toString(body.hoOutExecErabFailBitmap2(), "")).append(",");
        b.append(Objects.toString(body.uePowerClass(), "")).append(",");
        b.append(Objects.toString(body.plmnIndex(), "")).append(",");
        b.append(Objects.toString(body.ueCategoryFlex(), "")).append(",");
        b.append(Objects.toString(body.spidValue(), "")).append(",");
        b.append(Objects.toString(body.brCeLevel(), "")).append(",");
        b.append(Objects.toString(body.subscriberGroupId(), "")).append(",");
        b.append(Objects.toString(body.ueEndcStage(), "")).append(",");

        appendIntInfo(b, body.erabHoExecOutServiceType());

        b.append(Objects.toString(body.neighborNcgi(), "")).append(",");
        b.append(Objects.toString(body.hoPacketForward(), "")).append(",");
        return b.toString();

    }

    private String write_event_5153_ue_meas_intrafreq1(EricssonEventFile.TEventRecord
                                                               eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent5153Body body = eventRecord.event5153Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(body.reportConfigType(), "")).append(",");
        b.append(Objects.toString(body.rsrpserving(), "")).append(",");
        b.append(Objects.toString(body.rsrqserving(), "")).append(",");


        appendNeighbourInfo(b,
                body.physicalCellid1(), body.rsrpresult1(), body.rsrqresult1(),
                body.physicalCellid2(), body.rsrpresult2(), body.rsrqresult2(),
                body.physicalCellid3(), body.rsrpresult3(), body.rsrqresult3(),
                body.physicalCellid4(), body.rsrpresult4(), body.rsrqresult4(),
                body.physicalCellid5(), body.rsrpresult5(), body.rsrqresult5(),
                body.physicalCellid6(), body.rsrpresult6(), body.rsrqresult6(),
                body.physicalCellid7(), body.rsrpresult7(), body.rsrqresult7(),
                body.physicalCellid8(), body.rsrpresult8(), body.rsrqresult8()
        );

        return b.toString();

    }

    private String write_event_5267_ue_meas_interfreq1(EricssonEventFile.TEventRecord
                                                               eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent5267Body body = eventRecord.event5267Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(body.reportConfigType(), "")).append(",");
        b.append(Objects.toString(body.rsrpserving(), "")).append(",");
        b.append(Objects.toString(body.rsrqserving(), "")).append(",");
        b.append(Objects.toString(body.freq(), "")).append(",");

        appendNeighbourInfo(b,
                body.physicalCellid1(), body.rsrpresult1(), body.rsrqresult1(),
                body.physicalCellid2(), body.rsrpresult2(), body.rsrqresult2(),
                body.physicalCellid3(), body.rsrpresult3(), body.rsrqresult3(),
                body.physicalCellid4(), body.rsrpresult4(), body.rsrqresult4(),
                body.physicalCellid5(), body.rsrpresult5(), body.rsrqresult5(),
                body.physicalCellid6(), body.rsrpresult6(), body.rsrqresult6(),
                body.physicalCellid7(), body.rsrpresult7(), body.rsrqresult7(),
                body.physicalCellid8(), body.rsrpresult8(), body.rsrqresult8()
        );

        return b.toString();

    }

    private String write_event_5269_ue_meas_geran1(EricssonEventFile.TEventRecord
                                                           eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent5269Body body = eventRecord.event5269Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(body.reportConfigType(), "")).append(",");
        b.append(Objects.toString(body.rsrpserving(), "")).append(",");
        b.append(Objects.toString(body.rsrqserving(), "")).append(",");
        b.append(Objects.toString(body.freq(), "")).append(",");

        List<Integer> cellRssiInfo = Arrays.asList(
                body.physicalCellid1(), body.rssiresult1(), body.physicalCellid2(), body.rssiresult2(),
                body.physicalCellid3(), body.rssiresult3(), body.physicalCellid4(), body.rssiresult4(),
                body.physicalCellid5(), body.rssiresult5(), body.physicalCellid6(), body.rssiresult6(),
                body.physicalCellid7(), body.rssiresult7(), body.physicalCellid8(), body.rssiresult8(),

                body.physicalCellid12(), body.physicalCellid22(), body.physicalCellid32(), body.physicalCellid42(),
                body.physicalCellid52(), body.physicalCellid62(), body.physicalCellid72(), body.physicalCellid82()
        );
        appendIntInfo(b, cellRssiInfo);

        List<Long> neighborFrequencies = Arrays.asList(
                body.neighborFreq1(), body.neighborFreq2(), body.neighborFreq3(), body.neighborFreq4(),
                body.neighborFreq5(), body.neighborFreq6(), body.neighborFreq7(), body.neighborFreq8()
        );
        appendLongInfo(b, neighborFrequencies);
        return b.toString();

    }

    private String write_event_26_rrc_ue_information_response(EricssonEventFile.TEventRecord
                                                                      eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent26Body body = eventRecord.event26Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.messageDirection(), "")).append(",");
        b.append(Objects.toString(body.l3messageLength(), "")).append(",");
        b.append(Objects.toString(body.l3messageContents(), "")).append(",");
        b.append(Objects.toString(body.crnti(), "")).append(",");

        return b.toString();

    }

    private String write_event_4125_proc_ue_ctxt_release(EricssonEventFile.TEventRecord
                                                                 eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent4125Body body = eventRecord.event4125Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.triggeringNode(), "")).append(",");
        b.append(Objects.toString(body.s1ReleaseCause(), "")).append(",");
        b.append(Objects.toString(body.param3gppCauseGroup(), "")).append(",");
        b.append(Objects.toString(body.param3gppCause(), "")).append(",");
        b.append(Objects.toString(body.internalReleaseCause(), "")).append(",");

        appendIntInfo(b, body.erabDataLost());
        appendIntInfo(b, body.erabReleaseSucc());
        appendIntInfo(b, body.erabReleaseReqQci());
        appendIntInfo(b, body.hoOutPrepErabFail());
        appendIntInfo(b, body.hoOutPrepErabFailAndDataLost());
        appendIntInfo(b, body.hoOutExecErabFailAndDataLost());
        appendIntInfo(b, body.erabSetupReqArp());
        appendIntInfo(b, body.erabSetupReqPci());
        appendIntInfo(b, body.erabSetupReqPvi());

        appendTimestamp(b, body.timestampStartHour(), body.timestampStartMinute(), body.timestampStartSecond(), body.timestampStartMillisec());
        appendTimestamp(b, body.timestampStopHour(), body.timestampStopMinute(), body.timestampStopSecond(), body.timestampStopMillisec());


        b.append(Objects.toString(body.ttiBundlingMode(), "")).append(",");
        b.append(Objects.toString(body.ta(), "")).append(",");

        appendIntInfo(b, body.partialNodeRestartErabDataLost());
        appendIntInfo(b, body.erabReleaseSuccGbr());
        appendIntInfo(b, body.hoOutPrepErabFailGbr());
        appendIntInfo(b, body.hoOutPrepErabFailAndDataLostGbr());
        appendIntInfo(b, body.erabInactiveGap());

        b.append(Objects.toString(body.tac(), "")).append(",");

        b.append(Objects.toString(body.svn(), "")).append(",");
        b.append(Objects.toString(body.maskedsrn(), "")).append(",");
        b.append(Objects.toString(body.plmnIndex(), "")).append(",");
        b.append(Objects.toString(body.ueCategoryFlex(), "")).append(",");
        b.append(Objects.toString(body.spidValue(), "")).append(",");
        b.append(Objects.toString(body.uePowerClass(), "")).append(",");
        b.append(Objects.toString(body.brCeLevel(), "")).append(",");
        b.append(Objects.toString(body.subscriberGroupId(), "")).append(",");
        b.append(Objects.toString(body.uePreemptionCause(), "")).append(",");
        b.append(Objects.toString(body.ueEndcStage(), "")).append(",");
        b.append(Objects.toString(body.oldCombinedCovState(), "")).append(",");
        b.append(Objects.toString(body.currentCombinedCovState(), "")).append(",");

        return b.toString();
    }

    private String write_event_4121_proc_rrc_connection_re_establishment(EricssonEventFile.TEventRecord
                                                                                 eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent4121Body body = eventRecord.event4121Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        appendTimestamp(b, body.timestampStartHour(), body.timestampStartMinute(), body.timestampStartSecond(), body.timestampStartMillisecond());
        appendTimestamp(b, body.timestampStopHour(), body.timestampStopMinute(), body.timestampStopSecond(), body.timestampStopMillisecond());

        List<Integer> reestabMetrics = Arrays.asList(
                body.reestabCause(), body.reestabResult(), body.reestabMultiTargetType(), body.hoSourceOrTargetType(), body.hoType(),
                body.ttiBundlingMode(), body.admCtrlRejectingMsrPreemptionAttempted(), body.ta()
        );

        appendIntInfo(b, reestabMetrics);
        appendIntInfo(b, body.erabReestReqQci());
        appendIntInfo(b, body.erabReestResult());
        b.append(Objects.toString(body.tac(), "")).append(",");

        List<Integer> reestabFields = Arrays.asList(
                body.svn(), body.maskedsrn(),
                body.msrUlPrbUtilCellState(), body.msrUlPrbUtilBbmState(), body.msrDlPrbUtilCellState(), body.msrDlPrbUtilBbmState(),
                body.msrUlSeUtilCellState(), body.msrUlSeUtilBbmState(), body.msrDlSeUtilCellState(), body.msrDlSeUtilBbmState(),
                body.msrCceUtilCellState(),
                body.msrUlBbCapUtilBbmState(), body.msrDlBbCapUtilBbmState(),
                body.asn1Extension(),
                body.reestabCauseNb(),
                body.uePowerClass(),
                body.subscriberGroupId(),
                body.pdcpTypeInSource(),
                body.ueEndcStage(),
                body.reestabSourceEnbCandidateOtherVendor(), body.reestabSourceEnbCandidateEricsson(), body.reestabSourceEnbOtherVendor(),
                body.msrDlPrbPttReservationCellState(), body.msrDlSePttReservationCellState(), body.msrCcePttReservationCellState(), body.msrDlPrbPttReservationBbmState(),
                body.msrDlSePttReservationBbmState(), body.msrDlBbCapPttReservationBbmState(),
                body.paUser()
        );
        appendIntInfo(b, reestabFields);
        appendIntInfo(b, body.erabReestReqArp());

        return b.toString();

    }

    private String write_event_4097_proc_rrc_conn_setup(EricssonEventFile.TEventRecord
                                                                eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent4097Body body = eventRecord.event4097Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.initialUeIdentityType(), "")).append(",");
        b.append(Objects.toString(body.initialUeIdentity(), "")).append(",");
        b.append(Objects.toString(body.rrcEstabCause(), "")).append(",");
        b.append(Objects.toString(body.rrcResult(), "")).append(",");

        appendTimestamp(b, body.timestampStartHour(), body.timestampStartMinute(), body.timestampStartSecond(), body.timestampStartMillisec());
        appendTimestamp(b, body.timestampStopHour(), body.timestampStopMinute(), body.timestampStopSecond(), body.timestampStopMillisec());

        List<Integer> miscMetrics = Arrays.asList(
                body.gummeiType(),
                body.admCtrlRejectingMsrPreemptionAttempted(), body.admCtrlBlockingArp(),
                body.msrUlPrbUtilCellState(), body.msrUlPrbUtilBbmState(), body.msrDlPrbUtilCellState(), body.msrDlPrbUtilBbmState(),
                body.msrUlSeUtilCellState(), body.msrUlSeUtilBbmState(), body.msrDlSeUtilCellState(),
                body.msrDlSeUtilBbmState(), body.msrCceUtilCellState(), body.msrUlBbCapUtilBbmState(), body.msrDlBbCapUtilBbmState(),
                body.bandwidthReducedAccessCeMode(),
                body.rrcEstablCauseNb(),
                body.brCeLevel(),
                body.msrDlPrbPttReservationCellState(), body.msrDlSePttReservationCellState(), body.msrCcePttReservationCellState(),
                body.msrDlPrbPttReservationBbmState(), body.msrDlSePttReservationBbmState(), body.msrDlBbCapPttReservationBbmState(),
                body.duacPagingPool(),
                body.reattemptIndicator()
        );


        appendIntInfo(b, miscMetrics);


        return b.toString();

    }

    private String write_event_4106_proc_initial_ctxt_setup(EricssonEventFile.TEventRecord
                                                                    eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent4106Body body = eventRecord.event4106Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        appendIntInfo(b, body.erabSetupResult());
        appendIntInfo(b, body.erabSetupReqQci());
        appendIntInfo(b, body.erabSetupReqArp());
        appendIntInfo(b, body.erabSetupReqPci());
        appendIntInfo(b, body.erabSetupReqPvi());
        appendIntInfo(b, body.erabSetupAttAccType());
        appendIntInfo(b, body.erabSetupSuccAccType());
        appendIntInfo(b, body.erabSetupFailure3gppCauseGroup());
        appendIntInfo(b, body.erabSetupFailure3gppCause());

        b.append(Objects.toString(body.accumulatedUlRequestedGbr(), "")).append(",");
        b.append(Objects.toString(body.accumulatedDlRequestedGbr(), "")).append(",");
        b.append(Objects.toString(body.accumulatedUlAdmittedGbr(), "")).append(",");
        b.append(Objects.toString(body.accumulatedDlAdmittedGbr(), "")).append(",");

        b.append(Objects.toString(body.initialCtxtResult(), "")).append(",");
        b.append(Objects.toString(body.servingPlmnId(), "")).append(",");
        b.append(Objects.toString(body.param3gppCauseGroup(), "")).append(",");
        b.append(Objects.toString(body.param3gppCause(), "")).append(",");

        appendTimestamp(b, body.timestampStartHour(), body.timestampStartMinute(), body.timestampStartSecond(), body.timestampStartMillisec());
        appendTimestamp(b, body.timestampStopHour(), body.timestampStopMinute(), body.timestampStopSecond(), body.timestampStopMillisec());

        b.append(Objects.toString(body.ta(), "")).append(",");

        appendIntInfo(b, body.erabAdmCtrlBlockingArp());
        appendIntInfo(b, body.erabAdmCtrlRejectingMsrPreemptionAttempted());

        b.append(Objects.toString(body.ueHighestRecArp(), "")).append(",");
        b.append(Objects.toString(body.ueAdmCtrlBlockingArp(), "")).append(",");

        appendIntInfo(b, body.erabSetupAttemptGbr());
        appendIntInfo(b, body.erabSetupResultSuccReqGbr());

        b.append(Objects.toString(body.tac(), "")).append(",");
        b.append(Objects.toString(body.svn(), "")).append(",");
        b.append(Objects.toString(body.maskedsrn(), "")).append(",");
        b.append(Objects.toString(body.plmnIndex(), "")).append(",");
        b.append(Objects.toString(body.ueCategoryFlex(), "")).append(",");
        b.append(Objects.toString(body.spidValue(), "")).append(",");
        b.append(Objects.toString(body.bandwidthReducedAccessCeMode(), "")).append(",");
        b.append(Objects.toString(body.uePowerClass(), "")).append(",");
        b.append(Objects.toString(body.brCeLevel(), "")).append(",");
        b.append(Objects.toString(body.subscriberGroupId(), "")).append(",");

        appendIntInfo(b, body.erabSetupResultGbr());
        appendIntInfo(b, body.erabSetupResFailResult());
        appendIntInfo(b, body.erabSetupResFailResultGbr());

        b.append(Objects.toString(body.ueEndcStage(), "")).append(",");

        return b.toString();

    }

    private String write_event_4110_proc_ho_prep_x2_out(EricssonEventFile.TEventRecord
                                                                eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent4110Body body = eventRecord.event4110Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.hoSourceOrTargetType(), "")).append(",");
        b.append(Objects.toString(body.hoTargetSelectionType(), "")).append(",");
        b.append(Objects.toString(body.neighborCgi(), "")).append(",");

        b.append(Objects.toString(body.procHoPrepOutAttemptCause(), "")).append(",");
        b.append(Objects.toString(body.procHoPrepOutResult(), "")).append(",");
        b.append(Objects.toString(body.hoType(), "")).append(",");
        b.append(Objects.toString(body.hoOutPrepErabReqBitmap(), "")).append(",");
        b.append(Objects.toString(body.hoOutPrepErabFailBitmap(), "")).append(",");
        b.append(Objects.toString(body.param3gppCauseGroup(), "")).append(",");
        b.append(Objects.toString(body.param3gppCause(), "")).append(",");

        appendIntInfo(b, body.hoPrepQci());
        appendTimestamp(b, body.timestampStartHour(), body.timestampStartMinute(), body.timestampStartSecond(), body.timestampStartMillisec());
        appendTimestamp(b, body.timestampStopHour(), body.timestampStopMinute(), body.timestampStopSecond(), body.timestampStopMillisec());

        b.append(Objects.toString(body.tac(), "")).append(",");
        b.append(Objects.toString(body.svn(), "")).append(",");
        b.append(Objects.toString(body.maskedsrn(), "")).append(",");
        b.append(Objects.toString(body.ulEvaluation(), "")).append(",");
        b.append(Objects.toString(body.sinrMaxRsrpSource(), "")).append(",");
        b.append(Objects.toString(body.noiseInterferenceSource(), "")).append(",");
        b.append(Objects.toString(body.sinrMaxRsrpTarget(), "")).append(",");
        b.append(Objects.toString(body.noiseInterferenceTarget(), "")).append(",");
        b.append(Objects.toString(body.ultrigRejectCause(), "")).append(",");
        b.append(Objects.toString(body.hoOutPrepErabReqBitmap2(), "")).append(",");
        b.append(Objects.toString(body.hoOutPrepErabFailBitmap2(), "")).append(",");
        b.append(Objects.toString(body.uePowerClass(), "")).append(",");
        b.append(Objects.toString(body.subscriberGroupId(), "")).append(",");
        b.append(Objects.toString(body.ueCategoryFlex(), "")).append(",");
        b.append(Objects.toString(body.brCeLevel(), "")).append(",");
        b.append(Objects.toString(body.plmnIndex(), "")).append(",");
        b.append(Objects.toString(body.spidValue(), "")).append(",");
        b.append(Objects.toString(body.ueEndcStage(), "")).append(",");

        return b.toString();

    }

    private String write_event_4112_proc_ho_exec_x2_out(EricssonEventFile.TEventRecord
                                                                eventRecord, MergedCSVDecoderInput decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent4112Body body = eventRecord.event4112Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        b.append(Objects.toString(body.hoSourceOrTargetType(), "")).append(",");
        b.append(Objects.toString(body.hoTargetSelectionType(), "")).append(",");
        b.append(Objects.toString(body.neighborCgi(), "")).append(",");
        b.append(Objects.toString(body.hoPacketForward(), "")).append(",");
        b.append(Objects.toString(body.procHoExecOutResult(), "")).append(",");
        b.append(Objects.toString(body.hoType(), "")).append(",");
        b.append(Objects.toString(body.drxConfigIndex(), "")).append(",");
        b.append(Objects.toString(body.hoOutExecErabReqBitmap(), "")).append(",");
        b.append(Objects.toString(body.hoOutExecErabFailBitmap(), "")).append(",");
        b.append(Objects.toString(body.procHoExecOutAttemptCause(), "")).append(",");

        // erabHoExecOutQci (List<Integer>)
        appendIntInfo(b, body.erabHoExecOutQci());

        appendTimestamp(b, body.timestampStartHour(), body.timestampStartMinute(), body.timestampStartSecond(), body.timestampStartMillisec());
        appendTimestamp(b, body.timestampStopHour(), body.timestampStopMinute(), body.timestampStopSecond(), body.timestampStopMillisec());

        b.append(Objects.toString(body.ta(), "")).append(",");
        b.append(Objects.toString(body.triggerQuantity(), "")).append(",");
        b.append(Objects.toString(body.tac(), "")).append(",");
        b.append(Objects.toString(body.svn(), "")).append(",");
        b.append(Objects.toString(body.maskedsrn(), "")).append(",");
        b.append(Objects.toString(body.hoAfterResync(), "")).append(",");
        b.append(Objects.toString(body.hoStickyEarfcn(), "")).append(",");
        b.append(Objects.toString(body.hoOutExecErabReqBitmap2(), "")).append(",");
        b.append(Objects.toString(body.hoOutExecErabFailBitmap2(), "")).append(",");
        b.append(Objects.toString(body.uePowerClass(), "")).append(",");
        b.append(Objects.toString(body.subscriberGroupId(), "")).append(",");
        b.append(Objects.toString(body.ueCategoryFlex(), "")).append(",");
        b.append(Objects.toString(body.brCeLevel(), "")).append(",");
        b.append(Objects.toString(body.plmnIndex(), "")).append(",");
        b.append(Objects.toString(body.spidValue(), "")).append(",");
        b.append(Objects.toString(body.ueEndcStage(), "")).append(",");

        appendIntInfo(b, body.erabHoExecOutServiceType());

        return b.toString();
    }

    private String write_event_4099_erab_setup(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent4099Body body = eventRecord.event4099Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        appendIntInfo(b, body.erabSetupResult());
        appendIntInfo(b, body.erabSetupReqQci());
        appendIntInfo(b, body.erabSetupReqArp());
        appendIntInfo(b, body.erabSetupReqPci());
        appendIntInfo(b, body.erabSetupReqPvi());
        appendIntInfo(b, body.erabSetupAttAccType());
        appendIntInfo(b, body.erabSetupSuccAccType());
        appendIntInfo(b, body.erabSetupFailure3gppCauseGroup());
        appendIntInfo(b, body.erabSetupFailure3gppCause());

        // accumulated GBR fields
        b.append(Objects.toString(body.accumulatedUlRequestedGbr(), "")).append(",");
        b.append(Objects.toString(body.accumulatedDlRequestedGbr(), "")).append(",");
        b.append(Objects.toString(body.accumulatedUlAdmittedGbr(), "")).append(",");
        b.append(Objects.toString(body.accumulatedDlAdmittedGbr(), "")).append(",");

        // Timestamp Start
        appendTimestamp(b, body.timestampStartHour(), body.timestampStartMinute(), body.timestampStartSecond(), body.timestampStartMillisec());
        // Timestamp Stop
        appendTimestamp(b, body.timestampStopHour(), body.timestampStopMinute(), body.timestampStopSecond(), body.timestampStopMillisec());

        appendIntInfo(b, body.erabAdmCtrlBlockingArp());
        appendIntInfo(b, body.erabAdmCtrlRejectingMsrPreemptionAttempted());
        appendIntInfo(b, body.erabSetupResultSuccReqGbr());

        b.append(Objects.toString(body.tac(), "")).append(",");
        b.append(Objects.toString(body.svn(), "")).append(",");
        b.append(Objects.toString(body.maskedsrn(), "")).append(",");
        b.append(Objects.toString(body.plmnIndex(), "")).append(",");
        b.append(Objects.toString(body.ueCategoryFlex(), "")).append(",");
        b.append(Objects.toString(body.spidValue(), "")).append(",");
        b.append(Objects.toString(body.uePowerClass(), "")).append(",");
        b.append(Objects.toString(body.brCeLevel(), "")).append(",");
        b.append(Objects.toString(body.subscriberGroupId(), "")).append(",");

        appendIntInfo(b, body.erabSetupResultGbr());
        appendIntInfo(b, body.erabSetupResFailResult());
        appendIntInfo(b, body.erabSetupResFailResultGbr());

        b.append(Objects.toString(body.ueEndcStage(), "")).append(",");

        return b.toString();
    }

    private String write_event_3113_mdt5(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent3113Body body = eventRecord.event3113Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        List<Integer> mdtM2PowerHeadroom = Arrays.asList(
                body.mdtM2UePowerHeadroom0(), body.mdtM2UePowerHeadroom1(), body.mdtM2UePowerHeadroom2(), body.mdtM2UePowerHeadroom3(),
                body.mdtM2UePowerHeadroom4(), body.mdtM2UePowerHeadroom5(), body.mdtM2UePowerHeadroom6(), body.mdtM2UePowerHeadroom7(),
                body.mdtM2UePowerHeadroom8(), body.mdtM2UePowerHeadroom9(), body.mdtM2UePowerHeadroom10(), body.mdtM2UePowerHeadroom11(),
                body.mdtM2UePowerHeadroom12(), body.mdtM2UePowerHeadroom13(), body.mdtM2UePowerHeadroom14(), body.mdtM2UePowerHeadroom15()
        );

        appendIntInfo(b, mdtM2PowerHeadroom);

        return b.toString();

    }

    private String write_event_3131_mdt7(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent3131Body body = eventRecord.event3131Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        // mdtM7ErabPacketLostUl (List<Long>)
        appendLongInfo(b, body.mdtM7ErabPacketLostUl());
        // mdtM7ErabPacketRecUl (List<Long>)
        appendLongInfo(b, body.mdtM7ErabPacketRecUl());
        // mdtM7ErabPacketLostPelrUuDl (List<Long>)
        appendLongInfo(b, body.mdtM7ErabPacketLostPelrUuDl());
        // mdtM7ErabPacketTrDl (List<Long>)
        appendLongInfo(b, body.mdtM7ErabPacketTrDl());
        // mdtM7ErabQci (List<Integer>)
        appendIntInfo(b, body.mdtM7ErabQci());
        return b.toString();

    }

    private String write_event_3129_mdt6_ul(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent3129Body body = eventRecord.event3129Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        // erabExcDelayUl (List<Integer>)
        appendIntInfo(b, body.erabExcDelayUl());

        // erabQciUl (List<Integer>)
        appendIntInfo(b, body.erabQciUl());

        List<EricssonEventFile.TPolygon> mdtM6Polygons = Arrays.asList(
                body.mdtM6Polygon1(), body.mdtM6Polygon2(), body.mdtM6Polygon3(), body.mdtM6Polygon4(),
                body.mdtM6Polygon5(), body.mdtM6Polygon6(), body.mdtM6Polygon7()
        );


        appendLocationInfo(b, body.mdtM6LocationCoordinates(), body.mdtM6EllipsoidPoint(), body.mdtM6EllipsoidPointWithAlti(),
                body.mdtM6EllipsoidPointWithUncerCircle(), body.mdtM6EllipsoidPointWithUncerEllipse(),
                body.mdtM6EllipsoidPointWithAltiAndUncerEllipsoid(), body.mdtM6EllipsoidArc(), mdtM6Polygons);

        appendHorizontalVelocity(b, body.mdtM6HorizontalVelocity());

        b.append(Objects.toString(body.mdtM6GnssTodMsec(), "")).append(",");

        return b.toString();

    }

    private String write_event_3130_mdt6_dl(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent3130Body body = eventRecord.event3130Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        // Append mdtM6ErabLatTimeDl (List<Long>)
        appendLongInfo(b, body.mdtM6ErabLatTimeDl());

        // Append mdtM6ErabLatSamplDl (List<Long>)
        appendLongInfo(b, body.mdtM6ErabLatSamplDl());

        // Append mdtM6ErabQciDl (List<Integer>)
        appendIntInfo(b, body.mdtM6ErabQciDl());

        // Append mdtM6ErabDelayTimeDl (List<Long>)
        appendLongInfo(b, body.mdtM6ErabDelayTimeDl());

        // Append mdtM6ErabDelaySamplDl (List<Long>)
        appendLongInfo(b, body.mdtM6ErabDelaySamplDl());

        return b.toString();

    }

    private String write_event_3075_ue_radio_meas(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent3075Body body = eventRecord.event3075Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionReference());

        List<Long> radioMetrics = Arrays.asList(
                // RankTx
                body.rankTx0(), body.rankTx1(), body.rankTx2(), body.rankTx3(),
                body.rankTx4(), body.rankTx5(), body.rankTx6(), body.rankTx7(),

                // CQI Reported
                body.cqiReported0(), body.cqiReported1(), body.cqiReported2(), body.cqiReported3(),
                body.cqiReported4(), body.cqiReported5(), body.cqiReported6(), body.cqiReported7(),
                body.cqiReported8(), body.cqiReported9(), body.cqiReported10(), body.cqiReported11(),
                body.cqiReported12(), body.cqiReported13(), body.cqiReported14(), body.cqiReported15(),

                // Rank Reported
                body.rankReported0(), body.rankReported1(),

                // TBS Power
                body.tbspwrrestricted(), body.tbspwrunrestricted(),

                // CQI2 Reported
                body.cqi2Reported0(), body.cqi2Reported1(), body.cqi2Reported2(), body.cqi2Reported3(),
                body.cqi2Reported4(), body.cqi2Reported5(), body.cqi2Reported6(), body.cqi2Reported7(),
                body.cqi2Reported8(), body.cqi2Reported9(), body.cqi2Reported10(), body.cqi2Reported11(),
                body.cqi2Reported12(), body.cqi2Reported13(), body.cqi2Reported14(), body.cqi2Reported15(),

                // OutLoop Adj DL
                body.outLoopAdjDl0(), body.outLoopAdjDl1(), body.outLoopAdjDl2(), body.outLoopAdjDl3(),
                body.outLoopAdjDl4(), body.outLoopAdjDl5(), body.outLoopAdjDl6(), body.outLoopAdjDl7(),

                // SINR Meas PUSCH
                body.sinrMeasPusch0(), body.sinrMeasPusch1(), body.sinrMeasPusch2(), body.sinrMeasPusch3(),
                body.sinrMeasPusch4(), body.sinrMeasPusch5(), body.sinrMeasPusch6(), body.sinrMeasPusch7(),

                // SINR Meas PUCCH
                body.sinrMeasPucch0(), body.sinrMeasPucch1(), body.sinrMeasPucch2(), body.sinrMeasPucch3(),
                body.sinrMeasPucch4(), body.sinrMeasPucch5(), body.sinrMeasPucch6(), body.sinrMeasPucch7(),

                // Delta SINR Meas PUSCH
                body.deltaSinrMeasPusch0(), body.deltaSinrMeasPusch1(), body.deltaSinrMeasPusch2(), body.deltaSinrMeasPusch3(),
                body.deltaSinrMeasPusch4(), body.deltaSinrMeasPusch5(), body.deltaSinrMeasPusch6(), body.deltaSinrMeasPusch7()
        );

        appendLongInfo(b, radioMetrics);

        b.append(Objects.toString(body.aoa(), "")).append(",");
        b.append(Objects.toString(body.powerHeadroom(), "")).append(",");

        b.append(Objects.toString(body.rankTx8(), "")).append(",");
        b.append(Objects.toString(body.rankTx9(), "")).append(",");
        b.append(Objects.toString(body.rankTx10(), "")).append(",");
        b.append(Objects.toString(body.rankTx11(), "")).append(",");

        b.append(Objects.toString(body.powerHeadroomPrbUsed(), "")).append(",");

        b.append(Objects.toString(body.rankReported2(), "")).append(",");
        b.append(Objects.toString(body.rankReported3(), "")).append(",");

        b.append(Objects.toString(body.lastRiReported(), "")).append(",");
        b.append(Objects.toString(body.lastCqi1Reported(), "")).append(",");
        b.append(Objects.toString(body.lastCqi2Reported(), "")).append(",");
        b.append(Objects.toString(body.lastPuschNumPrbReported(), "")).append(",");
        b.append(Objects.toString(body.lastPuschSinrReported(), "")).append(",");
        b.append(Objects.toString(body.lastPuschPowerPerPrbReported(), "")).append(",");

        List<Long> advancedCqiRankMetrics = Arrays.asList(
                body.sinrMeasPusch8(),
                body.rankTx12(),
                body.rankTx13(),

                // HOM CQI Reported 0–15
                body.homCqiReported0(), body.homCqiReported1(), body.homCqiReported2(), body.homCqiReported3(),
                body.homCqiReported4(), body.homCqiReported5(), body.homCqiReported6(), body.homCqiReported7(),
                body.homCqiReported8(), body.homCqiReported9(), body.homCqiReported10(), body.homCqiReported11(),
                body.homCqiReported12(), body.homCqiReported13(), body.homCqiReported14(), body.homCqiReported15(),

                // HOM CQI2 Reported 0–15
                body.homCqi2Reported0(), body.homCqi2Reported1(), body.homCqi2Reported2(), body.homCqi2Reported3(),
                body.homCqi2Reported4(), body.homCqi2Reported5(), body.homCqi2Reported6(), body.homCqi2Reported7(),
                body.homCqi2Reported8(), body.homCqi2Reported9(), body.homCqi2Reported10(), body.homCqi2Reported11(),
                body.homCqi2Reported12(), body.homCqi2Reported13(), body.homCqi2Reported14(), body.homCqi2Reported15(),

                // HOM Rank Reported
                body.homRankReported0(), body.homRankReported1(), body.homRankReported2(), body.homRankReported3(),

                // CQI3 Reported 0–15
                body.cqi3Reported0(), body.cqi3Reported1(), body.cqi3Reported2(), body.cqi3Reported3(),
                body.cqi3Reported4(), body.cqi3Reported5(), body.cqi3Reported6(), body.cqi3Reported7(),
                body.cqi3Reported8(), body.cqi3Reported9(), body.cqi3Reported10(), body.cqi3Reported11(),
                body.cqi3Reported12(), body.cqi3Reported13(), body.cqi3Reported14(), body.cqi3Reported15(),

                // CQI4 Reported 0–15
                body.cqi4Reported0(), body.cqi4Reported1(), body.cqi4Reported2(), body.cqi4Reported3(),
                body.cqi4Reported4(), body.cqi4Reported5(), body.cqi4Reported6(), body.cqi4Reported7(),
                body.cqi4Reported8(), body.cqi4Reported9(), body.cqi4Reported10(), body.cqi4Reported11(),
                body.cqi4Reported12(), body.cqi4Reported13(), body.cqi4Reported14(), body.cqi4Reported15(),

                // HOM CQI3 Reported 0–15
                body.homCqi3Reported0(), body.homCqi3Reported1(), body.homCqi3Reported2(), body.homCqi3Reported3(),
                body.homCqi3Reported4(), body.homCqi3Reported5(), body.homCqi3Reported6(), body.homCqi3Reported7(),
                body.homCqi3Reported8(), body.homCqi3Reported9(), body.homCqi3Reported10(), body.homCqi3Reported11(),
                body.homCqi3Reported12(), body.homCqi3Reported13(), body.homCqi3Reported14(), body.homCqi3Reported15(),

                // HOM CQI4 Reported 0–15
                body.homCqi4Reported0(), body.homCqi4Reported1(), body.homCqi4Reported2(), body.homCqi4Reported3(),
                body.homCqi4Reported4(), body.homCqi4Reported5(), body.homCqi4Reported6(), body.homCqi4Reported7(),
                body.homCqi4Reported8(), body.homCqi4Reported9(), body.homCqi4Reported10(), body.homCqi4Reported11(),
                body.homCqi4Reported12(), body.homCqi4Reported13(), body.homCqi4Reported14(), body.homCqi4Reported15()
        );

        appendLongInfo(b, advancedCqiRankMetrics);

        b.append(Objects.toString(body.plmnIndex(), "")).append(",");
        b.append(Objects.toString(body.ueCategoryFlex(), "")).append(",");
        b.append(Objects.toString(body.spidValue(), "")).append(",");
        b.append(Objects.toString(body.brCeLevel(), "")).append(",");
        b.append(Objects.toString(body.uePowerClass(), "")).append(",");
        b.append(Objects.toString(body.subscriberGroupId(), "")).append(",");
        b.append(Objects.toString(body.endcStage(), "")).append(",");

        List<Long> extendedMetrics = Arrays.asList(
                // CQI Reported BR 0–15
                body.cqiReportedBr0(), body.cqiReportedBr1(), body.cqiReportedBr2(), body.cqiReportedBr3(),
                body.cqiReportedBr4(), body.cqiReportedBr5(), body.cqiReportedBr6(), body.cqiReportedBr7(),
                body.cqiReportedBr8(), body.cqiReportedBr9(), body.cqiReportedBr10(), body.cqiReportedBr11(),
                body.cqiReportedBr12(), body.cqiReportedBr13(), body.cqiReportedBr14(), body.cqiReportedBr15(),

                // MPDCCH Out Loop Adj DL BR 0–11
                body.mpdcchOutLoopAdjDlBr0(), body.mpdcchOutLoopAdjDlBr1(), body.mpdcchOutLoopAdjDlBr2(), body.mpdcchOutLoopAdjDlBr3(),
                body.mpdcchOutLoopAdjDlBr4(), body.mpdcchOutLoopAdjDlBr5(), body.mpdcchOutLoopAdjDlBr6(), body.mpdcchOutLoopAdjDlBr7(),
                body.mpdcchOutLoopAdjDlBr8(), body.mpdcchOutLoopAdjDlBr9(), body.mpdcchOutLoopAdjDlBr10(), body.mpdcchOutLoopAdjDlBr11(),

                // PDSCH Out Loop Adj DL BR 0–11
                body.pdschOutLoopAdjDlBr0(), body.pdschOutLoopAdjDlBr1(), body.pdschOutLoopAdjDlBr2(), body.pdschOutLoopAdjDlBr3(),
                body.pdschOutLoopAdjDlBr4(), body.pdschOutLoopAdjDlBr5(), body.pdschOutLoopAdjDlBr6(), body.pdschOutLoopAdjDlBr7(),
                body.pdschOutLoopAdjDlBr8(), body.pdschOutLoopAdjDlBr9(), body.pdschOutLoopAdjDlBr10(), body.pdschOutLoopAdjDlBr11(),

                // PUSCH Out Loop Adj DL BR 0–11
                body.puschOutLoopAdjDlBr0(), body.puschOutLoopAdjDlBr1(), body.puschOutLoopAdjDlBr2(), body.puschOutLoopAdjDlBr3(),
                body.puschOutLoopAdjDlBr4(), body.puschOutLoopAdjDlBr5(), body.puschOutLoopAdjDlBr6(), body.puschOutLoopAdjDlBr7(),
                body.puschOutLoopAdjDlBr8(), body.puschOutLoopAdjDlBr9(), body.puschOutLoopAdjDlBr10(), body.puschOutLoopAdjDlBr11(),

                // Rank Tx
                body.rankTx14(), body.rankTx15(),

                // SINR Meas PDCCH 0–11
                body.sinrMeasPdcch0(), body.sinrMeasPdcch1(), body.sinrMeasPdcch2(), body.sinrMeasPdcch3(),
                body.sinrMeasPdcch4(), body.sinrMeasPdcch5(), body.sinrMeasPdcch6(), body.sinrMeasPdcch7(),
                body.sinrMeasPdcch8(), body.sinrMeasPdcch9(), body.sinrMeasPdcch10(), body.sinrMeasPdcch11(),

                // SINR Meas PUSCH Extend 0–11
                body.sinrMeasPuschExtend0(), body.sinrMeasPuschExtend1(), body.sinrMeasPuschExtend2(), body.sinrMeasPuschExtend3(),
                body.sinrMeasPuschExtend4(), body.sinrMeasPuschExtend5(), body.sinrMeasPuschExtend6(), body.sinrMeasPuschExtend7(),
                body.sinrMeasPuschExtend8(), body.sinrMeasPuschExtend9(), body.sinrMeasPuschExtend10(), body.sinrMeasPuschExtend11(),

                // DTX indicators
                body.dtvmDtxInd(),
                body.utvmDtxInd()
        );

        appendLongInfo(b, extendedMetrics);

        return b.toString();


    }

    private String write_event_3076_ue_traffic(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent3076Body body = eventRecord.event3076Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionRef());


        List<Long> longParameters1 = Arrays.asList(
                body.perUeThpPdcpvolTrunkDl(), body.perUeThpTimeDl(), body.perUeThpPdcpvolTrunkUl(), body.perUeThpTimeUl(),
                body.perSchedActivityUeUl(), body.perSchedActivityUeDl(),
                body.perUePdcpSrbAckvolDl(), body.perUePdcpSrbTransvolDl(), body.perUePdcpSrbRecvolUl(),
                body.perUeRlcAckDl(), body.perUeRlcNackDl(), body.perUeRlcAckUl(), body.perUeRlcNackUl(),
                body.perUeDlMacDelay(),
                body.perUeHarqDlAckQpsk(), body.perUeHarqDlNackQpsk(), body.perUeHarqUlSuccQpsk(), body.ueHarqUlFailQpsk(),
                body.ueHarqDlAck16qam(), body.ueHarqDlNack16qam(), body.ueHarqUlSucc16qam(), body.ueHarqUlFail16qam(),
                body.ueHarqDlAck64qam(), body.ueHarqDlNack64qam(),
                body.perUeMacDtxUlQpsk(), body.perUeMacDtxDlQpsk(), body.perUeMacDtxDl16qam(), body.perUeMacDtxUl16qam(), body.perUeMacDtxDl64qam(),
                body.radiothpVolDl(), body.radiothpResDl(), body.radiothpVolUl(), body.radiothpResUl(),
                body.perUeThpDlDrb(), body.perUeThpUlDrb(), body.pdcpSduVoipUlpdbOk(),
                body.perUeRateShapeTimeUl(),
                body.perUeRlcPollRetxDl(), body.perUeRlcPollRetxUl(),
                body.ueHarqDlAck256qam(), body.ueHarqDlNack256qam(),
                body.perUeMacDtxDl256qam(),
                body.perUeThpMactimeDrbDl(), body.perUeThpMacvolDrbDl(), body.perUeThpMacDrbDl(), body.perUeThpMacvolUl(),
                body.perUeThpMactimeUl(), body.perUeThpMacUl(),
                body.ueHarqUlSucc64qam(), body.ueHarqUlFail64qam(),
                body.perUeMacDtxUl64qam()
        );

        appendLongInfo(b, longParameters1);

        b.append(Objects.toString(body.plmnIndex(), "")).append(",");
        b.append(Objects.toString(body.ueCategoryFlex(), "")).append(",");
        b.append(Objects.toString(body.spidValue(), "")).append(",");

        List<Long> harqAndAnmodeMetrics = Arrays.asList(
                body.ueHarqDlAckBpsk(), body.ueHarqDlNackBpsk(),
                body.dlharqAnmodeUsedFormat30(), body.dlharqAnmodeUsedFormat31(), body.dlharqAnmodeUsedFormat32(), body.dlharqAnmodeUsedFormat33(),
                body.dlharqAnmodeUsedMux0(), body.dlharqAnmodeUsedMux1(), body.dlharqAnmodeUsedMux2(), body.dlharqAnmodeUsedMux3(),
                body.format3ResCollision()
        );

        appendLongInfo(b, harqAndAnmodeMetrics);

        b.append(Objects.toString(body.uePowerClass(), "")).append(",");
        b.append(Objects.toString(body.brCeLevel(), "")).append(",");
        b.append(Objects.toString(body.ueVoipQualityUlOk(), "")).append(",");
        b.append(Objects.toString(body.ueVoipQualityUlNok(), "")).append(",");

        b.append(Objects.toString(body.subscriberGroupId(), "")).append(",");
        b.append(Objects.toString(body.perSchedActivityUeUlShortsps(), "")).append(",");
        b.append(Objects.toString(body.perUeThpTimeUlInitial(), "")).append(",");
        b.append(Objects.toString(body.perUeThpPdcpvolTrunkUlInitial(), "")).append(",");

        b.append(Objects.toString(body.ueEndcStage(), "")).append(",");

        List<Long> ulMetrics = Arrays.asList(
                body.perUeMacDtxUl256qam(),
                body.ueHarqUlFail256qam(), body.ueHarqUlSucc256qam(),
                body.perUeMacDtxUlSkipulpreschd(), body.perUeMacDtxUlSkipultxsps(), body.perUeMacDtxUlSkipuldyn(),
                body.ueHarqIuaUlFailQpsk(), body.ueHarqIuaUlFail16qam(),

                body.perUeMacUlUnresUePucchSrGrantSamp(), body.perUeMacVolUlResUe(), body.perUeMacTimeUlResUe(), body.perUeMacVolUlResUeLastTti(),
                body.perUeMacTimeUlResUeLastTtiSamp(), body.perUeMacVolUlResUeLate(), body.perUeMacTimeUlResUeLate(),

                body.perUlHeavyUeThpBeforeHo(), body.perUlHeavyUeThpAfterHo(), body.perUlHeavyUeRequiredTbsBeforeHo(), body.perUlHeavyUeRequiredTbsAfterHo(),
                body.perUeMacUlUnresUePreemptGrantSamp(), body.perUeMacUlUnresUeBsrGrantSamp(),
                body.perUeMacDtxUlSkipulpreschdVolte(), body.perUeMacDtxUlSkipuldynVolte(),
                body.perUlHeavyUeRequiredTbsBeforeHoSele(), body.perUlHeavyUeRequiredTbsAfterHoSele(), body.perUlHeavyUePcellThpBeforeHoSele(), body.perUlHeavyUePcellThpAfterHoSele(),
                body.perUlScellActivityStateBeforeSele(), body.perUlScellActivityStateAfterSele(), body.perUlScellThpBeforeSele(), body.perUlScellThpAfterSele(),

                body.ueHarqUlTrans1(), body.ueHarqUlTrans2(), body.ueHarqUlTrans3(), body.ueHarqUlTrans4(),
                body.ueHarqUlTrans5(), body.ueHarqUlTrans6(), body.ueHarqUlTrans7(), body.ueHarqUlAllDtx(),

                body.ueHarqDlTrans1(), body.ueHarqDlTrans2(), body.ueHarqDlTrans3(), body.ueHarqDlTrans4(),
                body.ueHarqDlTrans5(), body.ueHarqDlTrans6(), body.ueHarqDlTrans7(), body.ueHarqDlAllDtx(),

                body.perUeMacVolUlUnresUePucchSrGrant(), body.perUeMacVolUlUnresUePreemptGrant(), body.perUeMacVolUlUnresUeBsrGrant(),
                body.perUeThpPdcptimeDrbDl(), body.perSchedActivityUeUlcomp()
        );

        appendLongInfo(b, ulMetrics);

        return b.toString();

    }

    private String write_event_3114_mdt3(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent3114Body body = eventRecord.event3114Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisec());

        b.append(Objects.toString(body.scannerId(), "")).append(",");
        b.append(Objects.toString(body.rbsModuleId(), "")).append(",");
        b.append(Objects.toString(body.globalCellId(), "")).append(",");

        List<Long> mdtM3NoiseinterfMeas = Arrays.asList(
                body.mdtM3NoiseinterfMeas0(), body.mdtM3NoiseinterfMeas1(), body.mdtM3NoiseinterfMeas2(), body.mdtM3NoiseinterfMeas3(),
                body.mdtM3NoiseinterfMeas4(), body.mdtM3NoiseinterfMeas5(), body.mdtM3NoiseinterfMeas6(), body.mdtM3NoiseinterfMeas7(),
                body.mdtM3NoiseinterfMeas8(), body.mdtM3NoiseinterfMeas9(), body.mdtM3NoiseinterfMeas10(), body.mdtM3NoiseinterfMeas11(),
                body.mdtM3NoiseinterfMeas12(), body.mdtM3NoiseinterfMeas13(), body.mdtM3NoiseinterfMeas14(), body.mdtM3NoiseinterfMeas15()
        );

//        append mdtM3NoiseinterfMeas ( 16)
        appendLongInfo(b, mdtM3NoiseinterfMeas);

        return b.toString();
    }


    private String write_event_3116_mdt5(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent3116Body body = eventRecord.event3116Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionRef());

        b.append(Objects.toString(body.mdtM5UeThpTimeUl(), "")).append(",");
        b.append(Objects.toString(body.mdtM5UeThpVolUl(), "")).append(",");

        // mdtM5ErabThpTimeDl (List of 16)
        appendLongInfo(b, body.mdtM5ErabThpTimeDl());

        // mdtM5ErabThpVolDl (List of 16)
        appendLongInfo(b, body.mdtM5ErabThpVolDl());

        // erabQci (List of 16)
        appendIntInfo(b, body.erabQci());

        b.append(Objects.toString(body.mdtM5UeThpTimeDl(), "")).append(",");
        b.append(Objects.toString(body.mdtM5UeThpVolDl(), "")).append(",");
        b.append(Objects.toString(body.mdtM5UeLastttiVolDl(), "")).append(",");

        return b.toString();

    }

    private String write_event_3115_erab(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent3115Body body = eventRecord.event3115Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionRef());

        // mdtM4ErabPdcpVolUl
        for (EricssonEventFile.TE3115MdtM4ErabPdcpVolBlock block : body.mdtM4ErabPdcpVolUl()) {
            b.append(Objects.toString(block.mdtM4ErabPdcpVol(), "")).append(",");
        }

        // mdtM4ErabPdcpVolDl
        for (EricssonEventFile.TE3115MdtM4ErabPdcpVolBlock block : body.mdtM4ErabPdcpVolDl()) {
            b.append(Objects.toString(block.mdtM4ErabPdcpVol(), "")).append(",");
        }

        // mdtM4M5ErabQci: append each QCI
        appendIntInfo(b, body.mdtM4M5ErabQci());

        return b.toString();
    }

    private String write_event_3108_ta(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent3108Body body = eventRecord.event3108Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionRef());

        appendTimestamp(b, body.startTimestampHour(), body.startTimestampMinute(), body.startTimestampSecond(), body.startTimestampMillisecond());

        b.append(Objects.toString(body.taInterval(), "")).append(",");

        // Append each Timing Advance (TA) value
        for (Integer taVal : body.ta()) {
            b.append(Objects.toString(taVal, "")).append(",");
        }

        return b.toString();
    }

    private void appendLongInfo(StringBuilder b, List<Long> infos) {
        for (Long val : infos) {
            b.append(Objects.toString(val, "")).append(",");
        }
    }


    private void appendIntInfo(StringBuilder b, List<Integer> infos) {
        for (Integer val : infos) {
            b.append(Objects.toString(val, "")).append(",");
        }
    }

    private void appendTimestamp(StringBuilder b, int timestampHour, int timestampMinute,
                                 int timestampSecond, int timestampMillisecond) {
        b.append(Objects.toString(timestampHour, "")).append(",");
        b.append(Objects.toString(timestampMinute, "")).append(",");
        b.append(Objects.toString(timestampSecond, "")).append(",");
        b.append(Objects.toString(timestampMillisecond, "")).append(",");
    }

    private String write_event_3112_loc(EricssonEventFile.TEventRecord eventRecord, MergedCSVDecoderInput
            decoderInput, FilenameTimeInfo filenameTimeInfo) {
        EricssonEventFile.TEvent3112Body body = eventRecord.event3112Body();
        StringBuilder b = new StringBuilder();
        appendDateTimeAndValidity(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond(), filenameTimeInfo);

        appendRawTimeInfo(b, body.timestampHour(), body.timestampMinute(), body.timestampSecond(), body.timestampMillisecond());
        appendIdInfo(b, body.scannerId(), body.rbsModuleId(), body.globalCellId(), body.enbs1apid(),
                body.mmes1apid(), body.gummei(), body.racUeRef(), body.traceRecordingSessionRef());


        b.append(Objects.toString(body.affectedMeasType(), "")).append(",");
        b.append(Objects.toString(body.rsrpServing(), "")).append(",");
        b.append(Objects.toString(body.rsrqServing(), "")).append(",");

        appendNeighbourInfo(b,
                body.physicalCellId1(), body.rsrpResult1(), body.rsrqResult1(),
                body.physicalCellId2(), body.rsrpResult2(), body.rsrqResult2(),
                body.physicalCellId3(), body.rsrpResult3(), body.rsrqResult3(),
                body.physicalCellId4(), body.rsrpResult4(), body.rsrqResult4(),
                body.physicalCellId5(), body.rsrpResult5(), body.rsrqResult5(),
                body.physicalCellId6(), body.rsrpResult6(), body.rsrqResult6(),
                body.physicalCellId7(), body.rsrpResult7(), body.rsrqResult7(),
                body.physicalCellId8(), body.rsrpResult8(), body.rsrqResult8()
        );

        List<EricssonEventFile.TPolygon> polygonPoints = Arrays.asList(
                body.mdtM1Polygon1(),
                body.mdtM1Polygon2(),
                body.mdtM1Polygon3(),
                body.mdtM1Polygon4(),
                body.mdtM1Polygon5(),
                body.mdtM1Polygon6(),
                body.mdtM1Polygon7()
        );

        appendLocationInfo(b, body.mdtM1LocationCoordinates(), body.mdtM1EllipsoidPoint(), body.mdtM1EllipsoidPointWithAlti(),
                body.mdtM1EllipsoidPointWithUncerCircle(), body.mdtM1EllipsoidPointWithUncerEllipse(),
                body.mdtM1EllipsoidPointWithAltiAndUncerEllipsoid(), body.mdtM1EllipsoidArc(), polygonPoints);

        appendHorizontalVelocity(b, body.mdtM1HorizontalVelocity());

        b.append(Objects.toString(body.paramMdtM1GnssTodMsec(), "")).append(",");
        b.append(Objects.toString(body.mdtM1Frequency(), "")).append(",");

        return b.toString();
    }

    private void appendHorizontalVelocity(StringBuilder b, EricssonEventFile.THorizontalVelocity
            tHorizontalVelocity) {
        b.append(Objects.toString(tHorizontalVelocity.bearing(), "")).append(",");
        b.append(Objects.toString(tHorizontalVelocity.horizontalSpeed(), "")).append(",");
    }


    private void appendLocationInfo(StringBuilder b, int locationCoordinates, EricssonEventFile.
            TEllipsoidPoint tEllipsoidPoint,
                                    EricssonEventFile.TEllipsoidPointWithAlti tEllipsoidPointWithAlti,
                                    EricssonEventFile.TEllipsoidPointWithUncerCircle tEllipsoidPointWithUncerCircle,
                                    EricssonEventFile.TEllipsoidPointWithUncerEllipse tEllipsoidPointWithUncerEllipse,
                                    EricssonEventFile.TEllipsoidPointWithAltiAndUncerEllipsoid tEllipsoidPointWithAltiAndUncerEllipsoid,
                                    EricssonEventFile.TEllipsoidArc tEllipsoidArc, List<EricssonEventFile.TPolygon> polygonPoints) {

        b.append(Objects.toString(locationCoordinates, "")).append(",");

        LocationPart locationPart;

        switch (locationCoordinates) {
            case 0:
                locationPart = new LocationPart(tEllipsoidPoint.degreesLatitude(), tEllipsoidPoint.degreesLongitude(),
                        tEllipsoidPoint.latitudeSign());
            case 1:
                locationPart = new LocationPart(tEllipsoidPointWithAlti.degreesLatitude(),
                        tEllipsoidPointWithAlti.degreesLongitude(), tEllipsoidPointWithAlti.latitudeSign());
            case 2:
                locationPart = new LocationPart(tEllipsoidPointWithUncerCircle.degreesLatitude(),
                        tEllipsoidPointWithUncerCircle.degreesLongitude(), tEllipsoidPointWithUncerCircle.latitudeSign());
            case 3:
                locationPart = new LocationPart(tEllipsoidPointWithUncerEllipse.degreesLatitude(),
                        tEllipsoidPointWithUncerEllipse.degreesLongitude(), tEllipsoidPointWithUncerEllipse.latitudeSign());
            case 4:
                locationPart = new LocationPart(tEllipsoidPointWithAltiAndUncerEllipsoid.degreesLatitude(),
                        tEllipsoidPointWithAltiAndUncerEllipsoid.degreesLongitude(), tEllipsoidPointWithAltiAndUncerEllipsoid.latitudeSign());
            case 5:
                locationPart = new LocationPart(tEllipsoidArc.degreesLatitude(),
                        tEllipsoidArc.degreesLongitude(), tEllipsoidArc.latitudeSign());
            case 6:
                locationPart = new LocationPart(polygonPoints.get(0).degreesLatitude(),
                        polygonPoints.get(0).degreesLongitude(), polygonPoints.get(0).latitudeSign());
            case 7:
                locationPart = new LocationPart(polygonPoints.get(1).degreesLatitude(),
                        polygonPoints.get(1).degreesLongitude(), polygonPoints.get(1).latitudeSign());
            case 8:
                locationPart = new LocationPart(polygonPoints.get(2).degreesLatitude(),
                        polygonPoints.get(2).degreesLongitude(), polygonPoints.get(2).latitudeSign());
            case 9:
                locationPart = new LocationPart(polygonPoints.get(3).degreesLatitude(),
                        polygonPoints.get(3).degreesLongitude(), polygonPoints.get(3).latitudeSign());
            case 10:
                locationPart = new LocationPart(polygonPoints.get(4).degreesLatitude(),
                        polygonPoints.get(4).degreesLongitude(), polygonPoints.get(4).latitudeSign());
            case 11:
                locationPart = new LocationPart(polygonPoints.get(5).degreesLatitude(),
                        polygonPoints.get(5).degreesLongitude(), polygonPoints.get(5).latitudeSign());
            case 12:
                locationPart = new LocationPart(polygonPoints.get(6).degreesLatitude(),
                        polygonPoints.get(6).degreesLongitude(), polygonPoints.get(6).latitudeSign());
            default:
                locationPart = new LocationPart();
        }

        b.append(Objects.toString(locationPart.getDegreesLatitude(), "")).append(",");
        b.append(Objects.toString(locationPart.getDegreesLongitude(), "")).append(",");

        if (locationPart.getDegreesLatitude() != null && locationPart.getDegreesLongitude() != null) {
            b.append(Objects.toString(ConversionHelper.generateGeoHash(locationPart.getDegreesLatitude(), locationPart.getDegreesLongitude()), "")).append(",");
        } else {
            b.append(",");
        }


// Ellipsoid Point
        b.append(Objects.toString(tEllipsoidPoint.latitudeSign(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPoint.degreesLatitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPoint.degreesLongitude(), "")).append(",");

// Ellipsoid Point With Altitude
        b.append(Objects.toString(tEllipsoidPointWithAlti.latitudeSign(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAlti.degreesLatitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAlti.degreesLongitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAlti.altitudeDirection(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAlti.altitude(), "")).append(",");

// Ellipsoid Point With Uncertainty Circle
        b.append(Objects.toString(tEllipsoidPointWithUncerCircle.latitudeSign(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithUncerCircle.degreesLatitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithUncerCircle.degreesLongitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithUncerCircle.uncertainty(), "")).append(",");

// Ellipsoid Point With Uncertainty Ellipse
        b.append(Objects.toString(tEllipsoidPointWithUncerEllipse.latitudeSign(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithUncerEllipse.degreesLatitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithUncerEllipse.degreesLongitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithUncerEllipse.uncertaintySemiMajor(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithUncerEllipse.uncertaintySemiMinor(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithUncerEllipse.orientaionMajorAxis(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithUncerEllipse.confidence(), "")).append(",");

// Ellipsoid Point With Altitude And Uncertainty Ellipsoid
        b.append(Objects.toString(tEllipsoidPointWithAltiAndUncerEllipsoid.latitudeSign(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAltiAndUncerEllipsoid.degreesLatitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAltiAndUncerEllipsoid.degreesLongitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAltiAndUncerEllipsoid.altitudeDirection(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAltiAndUncerEllipsoid.altitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAltiAndUncerEllipsoid.uncertaintySemiMajor(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAltiAndUncerEllipsoid.uncertaintySemiMinor(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAltiAndUncerEllipsoid.orientaionMajorAxis(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAltiAndUncerEllipsoid.uncertaintyAltitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidPointWithAltiAndUncerEllipsoid.confidence(), "")).append(",");

// Ellipsoid Arc
        b.append(Objects.toString(tEllipsoidArc.latitudeSign(), "")).append(",");
        b.append(Objects.toString(tEllipsoidArc.degreesLatitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidArc.degreesLongitude(), "")).append(",");
        b.append(Objects.toString(tEllipsoidArc.innerRadius(), "")).append(",");
        b.append(Objects.toString(tEllipsoidArc.uncertaintyRadius(), "")).append(",");
        b.append(Objects.toString(tEllipsoidArc.offsetAngle(), "")).append(",");
        b.append(Objects.toString(tEllipsoidArc.includedAngle(), "")).append(",");
        b.append(Objects.toString(tEllipsoidArc.confidence(), "")).append(",");


        // polygon points
        for (EricssonEventFile.TPolygon polygon : polygonPoints) {
            b.append(Objects.toString(polygon.latitudeSign(), "")).append(",");
            b.append(Objects.toString(polygon.degreesLatitude(), "")).append(",");
            b.append(Objects.toString(polygon.degreesLongitude(), "")).append(",");
        }

    }

    private void appendNeighbourInfo(StringBuilder b,
                                     int physicalCellId1, int rsrp1, int rsrq1,
                                     int physicalCellId2, int rsrp2, int rsrq2,
                                     int physicalCellId3, int rsrp3, int rsrq3,
                                     int physicalCellId4, int rsrp4, int rsrq4,
                                     int physicalCellId5, int rsrp5, int rsrq5,
                                     int physicalCellId6, int rsrp6, int rsrq6,
                                     int physicalCellId7, int rsrp7, int rsrq7,
                                     int physicalCellId8, int rsrp8, int rsrq8) {

        b.append(Objects.toString(physicalCellId1, "")).append(",");
        b.append(Objects.toString(rsrp1, "")).append(",");
        b.append(Objects.toString(rsrq1, "")).append(",");

        b.append(Objects.toString(physicalCellId2, "")).append(",");
        b.append(Objects.toString(rsrp2, "")).append(",");
        b.append(Objects.toString(rsrq2, "")).append(",");

        b.append(Objects.toString(physicalCellId3, "")).append(",");
        b.append(Objects.toString(rsrp3, "")).append(",");
        b.append(Objects.toString(rsrq3, "")).append(",");

        b.append(Objects.toString(physicalCellId4, "")).append(",");
        b.append(Objects.toString(rsrp4, "")).append(",");
        b.append(Objects.toString(rsrq4, "")).append(",");

        b.append(Objects.toString(physicalCellId5, "")).append(",");
        b.append(Objects.toString(rsrp5, "")).append(",");
        b.append(Objects.toString(rsrq5, "")).append(",");

        b.append(Objects.toString(physicalCellId6, "")).append(",");
        b.append(Objects.toString(rsrp6, "")).append(",");
        b.append(Objects.toString(rsrq6, "")).append(",");

        b.append(Objects.toString(physicalCellId7, "")).append(",");
        b.append(Objects.toString(rsrp7, "")).append(",");
        b.append(Objects.toString(rsrq7, "")).append(",");

        b.append(Objects.toString(physicalCellId8, "")).append(",");
        b.append(Objects.toString(rsrp8, "")).append(",");
        b.append(Objects.toString(rsrq8, "")).append(",");
    }


    private void appendIdInfo(StringBuilder b, long scannerId, int rbsModuleId, long globalCellId, long enbs1apid,
                              long mmes1apid, long gummei, long racUeRef, long traceRecordingSessionRef) {
        b.append(Objects.toString(scannerId, "")).append(",");
        b.append(Objects.toString(rbsModuleId, "")).append(",");
        b.append(Objects.toString(globalCellId, "")).append(",");
        b.append(Objects.toString(enbs1apid, "")).append(",");
        b.append(Objects.toString(mmes1apid, "")).append(",");
        b.append(Objects.toString(gummei, "")).append(",");
        b.append(Objects.toString(racUeRef, "")).append(",");
        b.append(Objects.toString(traceRecordingSessionRef, "")).append(",");
    }

    private void appendRawTimeInfo(StringBuilder b, int timestampHour, int timestampMinute, int timestampSecond,
                                   int timestampMillisecond) {
        b.append(Objects.toString(timestampHour, "")).append(",");
        b.append(Objects.toString(timestampMinute, "")).append(",");
        b.append(Objects.toString(timestampSecond, "")).append(",");
        b.append(Objects.toString(timestampMillisecond, "")).append(",");
    }


    private void appendDateTimeAndValidity(StringBuilder b, int timeStampHour, int timeStampMinute,
                                           int timeStampSecond, int timeStampMilliseconds, FilenameTimeInfo filenameTimeInfo) {
        int hour = ((timeStampHour + filenameTimeInfo.getHourInc()) +
                ((timeStampMinute + filenameTimeInfo.getMinuteInc()) / 60)) % 24;
        int minute = (timeStampMinute + filenameTimeInfo.getMinuteInc()) % 60;

        String ymd = String.format("%s-%s-%s %02d:%02d:%02d.%03d",
                filenameTimeInfo.getYear(), filenameTimeInfo.getMonth(), filenameTimeInfo.getDate(),
                hour, minute, timeStampSecond, timeStampMilliseconds);

        b.append(ymd).append(",");
        if (ymd.compareTo(filenameTimeInfo.getStartYmd()) > 0 && ymd.compareTo(filenameTimeInfo.getEndYmd()) < 0) {
            b.append("True").append(",");
        } else {
            b.append("False").append(",");
        }
    }


}
