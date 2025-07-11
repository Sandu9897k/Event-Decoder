package com.altria.dialog.utils;

import com.altria.dialog.decoders.common.ConversionHelper;
import com.altria.dialog.decoders.huawei.HuaweiEventsReducer;
import com.altria.dialog.decoders.huawei.MergedCSVDecoderInput;
import com.altria.dialog.decoders.huawei.UserLocation;
import com.altria.dialog.parsers.kaitai.huawei.HuaweiChrEventFile;
import io.kaitai.struct.KaitaiStruct;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Objects;

import static com.altria.dialog.constant.AppConstant.*;

public class HuaweiChrCsvWriterUtil {

    public String writeCsv(int eventId, HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventRecord, MergedCSVDecoderInput decoderInput) {
        switch (eventId) {
            case 4097:
                return write_public_info_4097(eventRecord, decoderInput);
            case 4610:
                return write_intra_frq_mdt_4610(eventRecord, decoderInput);
            case 4625:
                return write_ta_mr_4625(eventRecord, decoderInput);
            case 4626:
                return write_ta_mdt_4626(eventRecord, decoderInput);
            case 4866:
                return write_intra_freq_mr_mdt_4866(eventRecord, decoderInput);
            case 4867:
                return write_m1_inter_freq_mdt_4867(eventRecord, decoderInput);
            case 4868:
                return write_m2_period_private_ue_meas_mdt_4868(eventRecord, decoderInput);
            case 4870:
                return write_m4_period_private_throughput_meas_mdt_4870(eventRecord, decoderInput);
            case 4871:
                return write_m5_period_private_throughput_meas_mdt_4871(eventRecord, decoderInput);
            case 4872:
                return write_rlf_report_4872(eventRecord, decoderInput);
            case 4873:
                return write_period_private_connest_fail_report_4873(eventRecord, decoderInput);
            case 4882:
                return write_periodUeUlpdcpdelayMdt_4882(eventRecord, decoderInput);
            case 4884:
                return write_periodPrivatePktlossrateMr_4884(eventRecord, decoderInput);
            case 4897:
                return write_periodPrivateUeMeasurementM2extmdt_4897(eventRecord, decoderInput);
            case 4898:
                return write_periodPrivateThroughputMeasurementM5extmdt_4898(eventRecord, decoderInput);
            case 4613:
                return write_uePeriodRadioLinkMr_4613(eventRecord, decoderInput);
            case 4108:
                return write_radio_link_failure_report_4108(eventRecord, decoderInput);
            case 4609:
                return write_ue_event_mr_4609(eventRecord, decoderInput);
            case 4611:
                return write_ue_period_inter_freq_mr_4611(eventRecord, decoderInput);
            case 4612:
                return write_ue_period_inter_rat_mr_4612(eventRecord, decoderInput);
            case 4614:
                return write_ue_period_intra_freq_mr_mdt_4614(eventRecord, decoderInput);
            case 4615:
                return write_ue_period_inter_freq_mr_mdt_4615(eventRecord, decoderInput);
            case 4617:
                return write_ue_period_radio_link_mr_mdt_4617(eventRecord, decoderInput);
            default:
                return null;
        }
    }

    private String write_ue_period_radio_link_mr_mdt_4617(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TUePeriodRadioLinkMrMdt body = eventTuple.eventRecord.uePeriodRadioLinkMrMdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.uePhr(), "")).append(",");
        b.append(Objects.toString(body.dlWidebandCqiCode0(), "")).append(",");
        b.append(Objects.toString(body.dlWidebandCqiCode1(), "")).append(",");
        b.append(Objects.toString(body.ulDmrsSinr(), "")).append(",");
        b.append(Objects.toString(body.taValue(), "")).append(",");
        b.append(Objects.toString(body.preambleTaValue(), "")).append(",");

        return b.toString();
    }

    private String write_ue_period_inter_freq_mr_mdt_4615(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TPeriodInterFreqMrMdt body = eventTuple.eventRecord.periodInterFreqMrMdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrq(), "")).append(",");

        int cellCount = body.ncellCount();
        b.append(Objects.toString(cellCount, "")).append(",");

        for (int i = 0; i < cellCount; i++) {
            b.append(Objects.toString(body.ncellInfoList().get(i).cellId(), "")).append(",");
            b.append(Objects.toString(body.ncellInfoList().get(i).pci(), "")).append(",");
            b.append(Objects.toString(body.ncellInfoList().get(i).carrierFrequency(), "")).append(",");
            b.append(Objects.toString(body.ncellInfoList().get(i).rsrp(), "")).append(",");
            b.append(Objects.toString(body.ncellInfoList().get(i).rsrq(), "")).append(",");
        }

        b.append(",,,,,".repeat(Math.max(0, TOTAL_NBR_CELL_COUNT - cellCount)));

        return b.toString();
    }

    private String write_ue_period_intra_freq_mr_mdt_4614(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TPeriodIntraFreqMrMdt body = eventTuple.eventRecord.periodIntraFreqMrMdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrq(), "")).append(",");

        int cellCount = body.ncellCount();
        b.append(Objects.toString(cellCount, "")).append(",");

        for (int i = 0; i < cellCount; i++) {
            b.append(Objects.toString(body.ncellInfoList().get(i).pci(), "")).append(",");
            b.append(Objects.toString(body.ncellInfoList().get(i).rsrp(), "")).append(",");
            b.append(Objects.toString(body.ncellInfoList().get(i).rsrq(), "")).append(",");
        }

        b.append(",,,".repeat(Math.max(0, TOTAL_NBR_CELL_COUNT - cellCount)));

        return b.toString();

    }

    private String write_ue_period_inter_rat_mr_4612(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TPeriodInterRatMr body = eventTuple.eventRecord.periodInterRatMr();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrq(), "")).append(",");
        b.append(Objects.toString(body.ncellType(), "")).append(",");

        Object ncellInfo = body.ncellInfo();

        if (!(ncellInfo instanceof HuaweiChrEventFile.TUeWcdmaNcellInfo)) {
            b.append(",");
            b.append(",,,".repeat(MAX_NCELLS_PER_CARRIER));
        } else {
            HuaweiChrEventFile.TUeWcdmaNcellInfo wcdma = (HuaweiChrEventFile.TUeWcdmaNcellInfo) ncellInfo;
            appendWcdmaUeInfo(b, wcdma);
        }

        if (!(ncellInfo instanceof HuaweiChrEventFile.TUeGeranNcellInfo)) {
            b.append(",");
            b.append(",,,,,".repeat(MAX_NCELLS_PER_CARRIER));
        } else {
            HuaweiChrEventFile.TUeGeranNcellInfo geran = (HuaweiChrEventFile.TUeGeranNcellInfo) ncellInfo;
            appendGeranUeInfo(b, geran);
        }

        if (!(ncellInfo instanceof HuaweiChrEventFile.TUeCdma2000NcellInfo)) {
            b.append(",");
            b.append(",,,".repeat(MAX_NCELLS_PER_CARRIER));
        } else {
            HuaweiChrEventFile.TUeCdma2000NcellInfo cdma2000 = (HuaweiChrEventFile.TUeCdma2000NcellInfo) ncellInfo;
            appendCdma2000UeInfo(b, cdma2000);
        }

        if (!(ncellInfo instanceof HuaweiChrEventFile.TUeTdScdmaNcellInfo)) {
            b.append(",");
            b.append(",,".repeat(MAX_NCELLS_PER_CARRIER));
        } else {
            HuaweiChrEventFile.TUeTdScdmaNcellInfo tdSdma = (HuaweiChrEventFile.TUeTdScdmaNcellInfo) ncellInfo;
            appendTdscdmaInfo(b, tdSdma);
        }

        return b.toString();
    }

    private String write_ue_period_inter_freq_mr_4611(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TPeriodInterFreqMr body = eventTuple.eventRecord.periodInterFreqMr();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrq(), "")).append(",");

        int cellCount = body.ncellCount();
        b.append(Objects.toString(cellCount, "")).append(",");

        for (int i = 0; i < cellCount; i++) {
            b.append(Objects.toString(body.ncellInfoList().get(i).pci(), "")).append(",");
            b.append(Objects.toString(body.ncellInfoList().get(i).rsrp(), "")).append(",");
            b.append(Objects.toString(body.ncellInfoList().get(i).rsrq(), "")).append(",");
        }

        b.append(",,,".repeat(Math.max(0, TOTAL_NBR_CELL_COUNT - cellCount)));

        return b.toString();
    }


    private String write_ue_event_mr_4609(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TUeEventMr body = eventTuple.eventRecord.ueEventMr();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(body.eventType(), "")).append(",");
        b.append(Objects.toString(body.servingCellPci(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrq(), "")).append(",");
        appendUeNbrCellInfo(b, body.ueEventNcellInfo());

        return b.toString();
    }

    private void appendUeNbrCellInfo(StringBuilder b, HuaweiChrEventFile.TUeEventNcellInfo tUeEventNcellInfo) {
        b.append(Objects.toString(tUeEventNcellInfo.ncellType(), "")).append(",");

        if (Objects.equals(tUeEventNcellInfo.eutranNcellInfo(), null)) {
            b.append(",");
            b.append(",,,".repeat(MAX_NCELLS_PER_CARRIER));
        } else {
            appendEutranUeInfo(b, tUeEventNcellInfo.eutranNcellInfo());
        }

        if (Objects.equals(tUeEventNcellInfo.wcdmaNcellInfo(), null)) {
            b.append(",");
            b.append(",,,".repeat(MAX_NCELLS_PER_CARRIER));
        } else {
            appendWcdmaUeInfo(b, tUeEventNcellInfo.wcdmaNcellInfo());
        }

        if (Objects.equals(tUeEventNcellInfo.geranNcellInfo(), null)) {
            b.append(",");
            b.append(",,,,,".repeat(MAX_NCELLS_PER_CARRIER));
        } else {
            appendGeranUeInfo(b, tUeEventNcellInfo.geranNcellInfo());
        }

        if (Objects.equals(tUeEventNcellInfo.cdma2000NcellInfo(), null)) {
            b.append(",");
            b.append(",,,".repeat(MAX_NCELLS_PER_CARRIER));
        } else {
            appendCdma2000UeInfo(b, tUeEventNcellInfo.cdma2000NcellInfo());
        }

        if (Objects.equals(tUeEventNcellInfo.tdScdmaNcellInfo(), null)) {
            b.append(",");
            b.append(",,".repeat(MAX_NCELLS_PER_CARRIER));
        } else {
            appendTdscdmaInfo(b, tUeEventNcellInfo.tdScdmaNcellInfo());
        }

        if (Objects.equals(tUeEventNcellInfo.nrNcellInfo(), null)) {
            b.append(",");
            b.append(",,,".repeat(MAX_NCELLS_PER_CARRIER));
        } else {
            appendNrUeInfo(b, tUeEventNcellInfo.nrNcellInfo());
        }
    }


    private void appendNrUeInfo(StringBuilder b, HuaweiChrEventFile.TUeNrNcellInfo tUeNrNcellInfo) {
        int cellCount = tUeNrNcellInfo.ncellCount();
        b.append(Objects.toString(cellCount, "")).append(",");
        for (int j = 0; j < cellCount; j++) {
            b.append(Objects.toString(tUeNrNcellInfo.ncellList().get(j).pci(), "")).append(",");
            b.append(Objects.toString(tUeNrNcellInfo.ncellList().get(j).carrierFreq(), "")).append(",");
            b.append(Objects.toString(tUeNrNcellInfo.ncellList().get(j).rsrp(), "")).append(",");
        }
        b.append(",,,".repeat(Math.max(0, MAX_NCELLS_PER_CARRIER - cellCount)));
    }

    private void appendTdscdmaInfo(StringBuilder b, HuaweiChrEventFile.TUeTdScdmaNcellInfo tUeTdScdmaNcellInfo) {
        int cellCount = tUeTdScdmaNcellInfo.ncellCount();
        b.append(Objects.toString(cellCount, "")).append(",");
        for (int j = 0; j < cellCount; j++) {
            b.append(Objects.toString(tUeTdScdmaNcellInfo.ncellList().get(j).pci(), "")).append(",");
            b.append(Objects.toString(tUeTdScdmaNcellInfo.ncellList().get(j).pccpchRscp(), "")).append(",");
        }
        b.append(",,".repeat(Math.max(0, MAX_NCELLS_PER_CARRIER - cellCount)));
    }

    private void appendCdma2000UeInfo(StringBuilder b, HuaweiChrEventFile.TUeCdma2000NcellInfo tUeCdma2000NcellInfo) {
        int cellCount = tUeCdma2000NcellInfo.ncellCount();
        b.append(Objects.toString(cellCount, "")).append(",");
        for (int j = 0; j < cellCount; j++) {
            b.append(Objects.toString(tUeCdma2000NcellInfo.ncellList().get(j).pci(), "")).append(",");
            b.append(Objects.toString(tUeCdma2000NcellInfo.ncellList().get(j).pilotPnPhase(), "")).append(",");
            b.append(Objects.toString(tUeCdma2000NcellInfo.ncellList().get(j).pilotStrength(), "")).append(",");

        }
        b.append(",,,".repeat(Math.max(0, MAX_NCELLS_PER_CARRIER - cellCount)));

    }

    private void appendGeranUeInfo(StringBuilder b, HuaweiChrEventFile.TUeGeranNcellInfo tUeGeranNcellInfo) {
        int cellCount = tUeGeranNcellInfo.ncellCount();
        b.append(Objects.toString(cellCount, "")).append(",");
        for (int i = 0; i < cellCount; i++) {
            b.append(Objects.toString(tUeGeranNcellInfo.ncellList().get(i).networkColourCode(), "")).append(",");
            b.append(Objects.toString(tUeGeranNcellInfo.ncellList().get(i).baseStateColourCode(), "")).append(",");
            b.append(Objects.toString(tUeGeranNcellInfo.ncellList().get(i).arfcn(), "")).append(",");
            b.append(Objects.toString(tUeGeranNcellInfo.ncellList().get(i).bindIndicator(), "")).append(",");
            b.append(Objects.toString(tUeGeranNcellInfo.ncellList().get(i).rssi(), "")).append(",");
        }
        b.append(",,,,,".repeat(Math.max(0, MAX_GERAN_CELL_COUNT - cellCount)));


    }

    private void appendWcdmaUeInfo(StringBuilder b, HuaweiChrEventFile.TUeWcdmaNcellInfo tUeWcdmaNcellInfo) {
        int cellCount = tUeWcdmaNcellInfo.ncellCount();
        b.append(Objects.toString(cellCount, "")).append(",");
        for (int i = 0; i < cellCount; i++) {
            b.append(Objects.toString(tUeWcdmaNcellInfo.ncellList().get(i).pci(), "")).append(",");
            b.append(Objects.toString(tUeWcdmaNcellInfo.ncellList().get(i).rscp(), "")).append(",");
            b.append(Objects.toString(tUeWcdmaNcellInfo.ncellList().get(i).ecNo(), "")).append(",");
        }

        b.append(",,,".repeat(Math.max(0, MAX_NCELLS_PER_CARRIER - cellCount)));

    }

    private void appendEutranUeInfo(StringBuilder b, HuaweiChrEventFile.TUeEutranNcellInfo tUeEutranNcellInfo) {
        int cellCount = tUeEutranNcellInfo.ncellCount();
        b.append(Objects.toString(cellCount, "")).append(",");

        for (int j = 0; j < cellCount; j++) {
            b.append(Objects.toString(tUeEutranNcellInfo.ncellList().get(j).pci(), "")).append(",");
            b.append(Objects.toString(tUeEutranNcellInfo.ncellList().get(j).rsrp(), "")).append(",");
            b.append(Objects.toString(tUeEutranNcellInfo.ncellList().get(j).rsrq(), "")).append(",");
        }
        b.append(",,,".repeat(Math.max(0, MAX_NCELLS_PER_CARRIER - cellCount)));

    }


    private String write_radio_link_failure_report_4108(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TRadioLinkFailureReport body = eventTuple.eventRecord.radioLinkFailureReport();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrq(), "")).append(",");

        appendFailedPcellInfo100C(b, body.failedPcellInfo());
        appendReEstablishmentCellInfo(b, body.reEstablishmentCellInfo());

        b.append(Objects.toString(body.timeConnectionFailure(), "")).append(",");
        b.append(Objects.toString(body.connectionFailureType(), "")).append(",");

        appendPreviousPcellInfo(b, body.previousPcellInfo());

        b.append(Objects.toString(body.eutranNcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.eutranCarrierFrequencyCount(), "")).append(",");
        appendEutran100CInfo(b, body.eutranCarrierFrequencyCount(), body.eutranCarrierFrequencyList());

        b.append(Objects.toString(body.utranNcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.utranCarrierFrequencyCount(), "")).append(",");
        appendUtranInfo(b, body.utranCarrierFrequencyCount(), body.utranCarrierFrequencyList());

        b.append(Objects.toString(body.geranNcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.geranNcellCount(), "")).append(",");
        appendGeranCellInfo(b, body.geranNcellCount(), body.geranNcellInfoList());

        b.append(Objects.toString(body.cdma2000NcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.cdma2000CarrierFrequencyCount(), "")).append(",");
        appendCdma2000Info(b, body.cdma2000CarrierFrequencyCount(), body.cdma2000CarrierFrequencyList());

        return b.toString();
    }

    private String write_uePeriodRadioLinkMr_4613(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TUePeriodRadioLinkMr body = eventTuple.eventRecord.uePeriodRadioLinkMr();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.uePhr(), "")).append(",");
        b.append(Objects.toString(body.dlWidebandCqiCode0(), "")).append(",");
        b.append(Objects.toString(body.dlWidebandCqiCode1(), "")).append(",");
        b.append(Objects.toString(body.ulDmrsSinr(), "")).append(",");
        b.append(Objects.toString(body.taValue(), "")).append(",");
        b.append(Objects.toString(body.preambleTaValue(), "")).append(",");
        b.append(Objects.toString(body.ulSrsSinr(), "")).append(",");

        return b.toString();
    }

    private String write_periodPrivateThroughputMeasurementM5extmdt_4898(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TPeriodPrivateThroughputMeasurementM5extmdt body = eventTuple.eventRecord.periodPrivateThroughputMeasurementM5extmdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.ulMcs(), "")).append(",");
        b.append(Objects.toString(body.dlMcs(), "")).append(",");

        return b.toString();
    }

    private String write_periodPrivateUeMeasurementM2extmdt_4897(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TPeriodPrivateUeMeasurementM2extmdt body = eventTuple.eventRecord.periodPrivateUeMeasurementM2extmdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.ulRetransErrorNumber(), "")).append(",");
        b.append(Objects.toString(body.ulCrcInitTransTotalNumber(), "")).append(",");
        b.append(Objects.toString(body.dlRetransErrorNumber(), "")).append(",");
        b.append(Objects.toString(body.dlCode0InitTransTotalNumber(), "")).append(",");
        b.append(Objects.toString(body.dlCode1InitTransTotalNumber(), "")).append(",");
        b.append(Objects.toString(body.ulRbUsedNumber(), "")).append(",");
        b.append(Objects.toString(body.dlRbUsedNumber(), "")).append(",");
        b.append(Objects.toString(body.dlWidebandCqiCode0(), "")).append(",");
        b.append(Objects.toString(body.dlWidebandCqiCode1(), "")).append(",");
        b.append(Objects.toString(body.rankIndication(), "")).append(",");

        return b.toString();

    }

    private String write_periodPrivatePktlossrateMr_4884(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TPeriodPrivatePktlossrateMr body = eventTuple.eventRecord.periodPrivatePktlossrateMr();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.qciCount(), "")).append(",");
        appendPacketLossInfo(b, body.qciCount(), body.packetLossInfoList());

        return b.toString();
    }

    private String write_periodUeUlpdcpdelayMdt_4882(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TPeriodUeUlpdcpdelayMdt body = eventTuple.eventRecord.periodUeUlpdcpdelayMdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.qciCount(), "")).append(",");
        appendUlPdcpDelayResult(b, body.qciCount(), body.ulPdcpDelayResultList());

        appendLocationInfo(b, body.locationInfoPresent(), body.shapeType(), body.undefinedInfo(),
                body.ellipsoidPointInfo(),
                body.ellipsoidPointWithAltitudeInfo(),
                body.ellipsoidPointWithUncertaintyCircleInfo(),
                body.ellipsoidPointWithUncertaintyEllipseInfo(),
                body.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo());

        return b.toString();
    }

    private String write_period_private_connest_fail_report_4873(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TPeriodPrivateConnestFailReport body = eventTuple.eventRecord.periodPrivateConnestFailReport();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.failedCellId(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrq(), "")).append(",");
        b.append(Objects.toString(body.numPreamblesSent(), "")).append(",");
        b.append(Objects.toString(body.contentionDetectedFlag(), "")).append(",");
        b.append(Objects.toString(body.maxTxPowerReachedFlag(), "")).append(",");
        b.append(Objects.toString(body.timeFromFailure(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");

        b.append(Objects.toString(body.eutranNcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.eutranCarrierFrequencyCount(), "")).append(",");
        appendEutranInfo(b, body.eutranCarrierFrequencyCount(), body.eutranCarrierFrequencyList());

        b.append(Objects.toString(body.utranNcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.utranCarrierFrequencyCount(), "")).append(",");
        appendUtranInfo(b, body.utranCarrierFrequencyCount(), body.utranCarrierFrequencyList());

        b.append(Objects.toString(body.geranNcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.geranNcellCount(), "")).append(",");
        appendGeranCellInfo(b, body.geranNcellCount(), body.geranNcellInfoList());

        b.append(Objects.toString(body.cdma2000NcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.cdma2000CarrierFrequencyCount(), "")).append(",");
        appendCdma2000Info(b, body.cdma2000CarrierFrequencyCount(), body.cdma2000CarrierFrequencyList());

        appendLocationInfo(b, body.locationInfoPresent(), body.shapeType(), body.undefinedInfo(),
                body.ellipsoidPointInfo(),
                body.ellipsoidPointWithAltitudeInfo(),
                body.ellipsoidPointWithUncertaintyCircleInfo(),
                body.ellipsoidPointWithUncertaintyEllipseInfo(),
                body.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo());

        return b.toString();
    }

    private String write_rlf_report_4872(HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput decoderInput) {
        HuaweiChrEventFile.TRlfReport body = eventTuple.eventRecord.rlfReport();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrq(), "")).append(",");

        appendFailedPcellInfo(b, body.failedPcellInfo());
        appendReEstablishmentCellInfo(b, body.reEstablishmentCellInfo());

        b.append(Objects.toString(body.timeConnectionFailure(), "")).append(",");
        b.append(Objects.toString(body.connectionFailureType(), "")).append(",");

        appendPreviousPcellInfo(b, body.previousPcellInfo());

        //eutran
        b.append(Objects.toString(body.eutranNcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.eutranCarrierFrequencyCount(), "")).append(",");
        appendEutranInfo(b, body.eutranCarrierFrequencyCount(), body.eutranCarrierFrequencyList());

        //utran
        b.append(Objects.toString(body.utranNcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.utranCarrierFrequencyCount(), "")).append(",");
        appendUtranInfo(b, body.utranCarrierFrequencyCount(), body.utranCarrierFrequencyList());

        //geran
        b.append(Objects.toString(body.geranNcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.geranNcellCount(), "")).append(",");
        appendGeranCellInfo(b, body.geranNcellCount(), body.geranNcellInfoList());

        //cdma200
        b.append(Objects.toString(body.cdma2000NcellMrValidFlag(), "")).append(",");
        b.append(Objects.toString(body.cdma2000CarrierFrequencyCount(), "")).append(",");
        appendCdma2000Info(b, body.cdma2000CarrierFrequencyCount(), body.cdma2000CarrierFrequencyList());

        //location info
        appendLocationInfo(b, body.locationInfoPresent(), body.shapeType(), body.undefinedInfo(),
                body.ellipsoidPointInfo(),
                body.ellipsoidPointWithAltitudeInfo(),
                body.ellipsoidPointWithUncertaintyCircleInfo(),
                body.ellipsoidPointWithUncertaintyEllipseInfo(),
                body.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo());

        return b.toString();

    }

    private String write_m5_period_private_throughput_meas_mdt_4871
            (HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput
                    decoderInput) {
        HuaweiChrEventFile.TPeriodPrivateThroughputMeasurementM5mdt body = eventTuple.eventRecord.periodPrivateThroughputMeasurementM5mdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.ulDataVolumePerUe(), "")).append(",");
        b.append(Objects.toString(body.ulDataVolumeLastTtiPerUe(), "")).append(",");
        b.append(Objects.toString(body.ulDataTransmissionTimePerUe(), "")).append(",");
        b.append(Objects.toString(body.dlDataVolumePerUe(), "")).append(",");
        b.append(Objects.toString(body.dlDataVolumeLastTtiPerUe(), "")).append(",");
        b.append(Objects.toString(body.dlDataTransmissionTimePerUe(), "")).append(",");

        int eRabCount = body.eRabCount();
        b.append(Objects.toString(eRabCount, "")).append(",");

        for (int i = 0; i < eRabCount; i++) {
            b.append(Objects.toString(body.eRabThroughputStatList().get(i).eRabId(), "")).append(",");
            b.append(Objects.toString(body.eRabThroughputStatList().get(i).qci(), "")).append(",");
            b.append(Objects.toString(body.eRabThroughputStatList().get(i).ulDataVolumePerERab(), "")).append(",");
            b.append(Objects.toString(body.eRabThroughputStatList().get(i).ulDataTransmissionTimePerERab(), "")).append(",");
            b.append(Objects.toString(body.eRabThroughputStatList().get(i).dlDataVolumePerERab(), "")).append(",");
            b.append(Objects.toString(body.eRabThroughputStatList().get(i).dlDataTransmissionTimePerERab(), "")).append(",");
        }

        b.append(",,,,,,".repeat(Math.max(0, TOTAL_ERAB_COUNT - eRabCount)));

        return b.toString();
    }

    private String write_m4_period_private_throughput_meas_mdt_4870
            (HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput
                    decoderInput) {
        HuaweiChrEventFile.TPeriodPrivateThroughputMeasurementM4mdt body = eventTuple.eventRecord.periodPrivateThroughputMeasurementM4mdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        int eRabCount = body.eRabCount();
        b.append(Objects.toString(eRabCount, "")).append(",");

        for (int i = 0; i < eRabCount; i++) {
            b.append(Objects.toString(body.eRabThroughputStatList().get(i).eRabId(), "")).append(",");
            b.append(Objects.toString(body.eRabThroughputStatList().get(i).qci(), "")).append(",");
            b.append(Objects.toString(body.eRabThroughputStatList().get(i).ulDataVolume(), "")).append(",");
            b.append(Objects.toString(body.eRabThroughputStatList().get(i).dlDataVolume(), "")).append(",");
        }
        b.append(",,,,".repeat(Math.max(0, TOTAL_ERAB_COUNT - eRabCount)));

        return b.toString();
    }

    private String write_m2_period_private_ue_meas_mdt_4868
            (HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput
                    decoderInput) {
        HuaweiChrEventFile.TPeriodPrivateUeMeasurementM2mdt body = eventTuple.eventRecord.periodPrivateUeMeasurementM2mdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.uePhr(), "")).append(",");

        return b.toString();
    }

    private String write_m1_inter_freq_mdt_4867
            (HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput
                    decoderInput) {
        HuaweiChrEventFile.TM1InterFreqMdt body = eventTuple.eventRecord.m1InterFreqMdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrq(), "")).append(",");

        int cellCount = body.nCellCount();
        b.append(Objects.toString(cellCount, "")).append(",");

        for (int i = 0; i < cellCount; i++) {
            b.append(Objects.toString(body.cellInfoList().get(i).cellId(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).pci(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).carrierFrequency(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).rsrp(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).rsrq(), "")).append(",");
        }

        b.append(",,,,,".repeat(Math.max(0, TOTAL_NBR_CELL_COUNT - cellCount)));

        appendLocationInfo(b, body.locationInfoPresent(), body.shapeType(), body.undefinedInfo(),
                body.ellipsoidPointInfo(),
                body.ellipsoidPointWithAltitudeInfo(),
                body.ellipsoidPointWithUncertaintyCircleInfo(),
                body.ellipsoidPointWithUncertaintyEllipseInfo(),
                body.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo());

        return b.toString();

    }

    private String write_intra_freq_mr_mdt_4866
            (HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput
                    decoderInput) {
        HuaweiChrEventFile.TM1IntraFreqMdt body = eventTuple.eventRecord.m1IntraFreqMdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrp(), "")).append(",");
        b.append(Objects.toString(body.servingCellRsrq(), "")).append(",");

        int cellCount = body.nCellCount();
        b.append(Objects.toString(cellCount, "")).append(",");

        for (int i = 0; i < cellCount; i++) {
            b.append(Objects.toString(body.cellInfoList().get(i).pci(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).rsrp(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).rsrq(), "")).append(",");
        }

        b.append(",,,".repeat(Math.max(0, TOTAL_NBR_CELL_COUNT - cellCount)));

        appendLocationInfo(b, body.locationInfoPresent(), body.shapeType(), body.undefinedInfo(),
                body.ellipsoidPointInfo(),
                body.ellipsoidPointWithAltitudeInfo(),
                body.ellipsoidPointWithUncertaintyCircleInfo(),
                body.ellipsoidPointWithUncertaintyEllipseInfo(),
                body.ellipsoidPointWithAltitudAndUncertaintyEllipsoidInfo());

        return b.toString();
    }

    private String write_ta_mdt_4626
            (HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput
                    decoderInput) {
        HuaweiChrEventFile.TPeriodUeTaMdt body = eventTuple.eventRecord.periodUeTaMdt();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.ta(), "")).append(",");
        return b.toString();
    }

    private String write_ta_mr_4625
            (HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput
                    decoderInput) {
        HuaweiChrEventFile.TPeriodUeTaMr body = eventTuple.eventRecord.periodUeTaMr();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.ta(), "")).append(",");
        return b.toString();

    }

    private String write_intra_frq_mdt_4610
            (HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput
                    decoderInput) {

        HuaweiChrEventFile.TPeriodIntraFrepMeasurement body = eventTuple.eventRecord.periodIntraFrepMr();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        b.append(Objects.toString(body.measurementId(), "")).append(",");
        b.append(Objects.toString(body.rsrpRslt(), "")).append(",");
        b.append(Objects.toString(body.rsrqRslt(), "")).append(",");

        int cellCount = body.nCellCount();
        b.append(Objects.toString(cellCount, "")).append(",");

        for (int i = 0; i < cellCount; i++) {
            b.append(Objects.toString(body.cellInfoList().get(i).pci(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).rsrp(), "")).append(",");
            b.append(Objects.toString(body.cellInfoList().get(i).rsrq(), "")).append(",");
        }

        for (int j = 0; j < TOTAL_NBR_CELL_COUNT - cellCount; j++) {
            b.append(",,,");
        }

        return b.toString();


    }

    private String write_public_info_4097
            (HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, MergedCSVDecoderInput
                    decoderInput) {
        HuaweiChrEventFile.TPublicInformation body = eventTuple.eventRecord.publicInformation();
        StringBuilder b = new StringBuilder();
        appendDateAndSeviceCellIdAndCallId(b, eventTuple, decoderInput.getTimeZoneId());

        if (Objects.equals(body.plmn(), null)) {
            b.append(",,");
        } else {
            b.append(Objects.toString(body.plmn().plmnIdReserved(), "")).append(",");
            b.append(Objects.toString(decodePlmnId(body.plmn().plmnId()), "")).append(",");
        }
        b.append(Objects.toString(body.mmeGroupId(), "")).append(",");
        b.append(Objects.toString(body.mmeCode(), "")).append(",");
        b.append(Objects.toString(body.mtmsi(), "")).append(",");
        b.append(Objects.toString(body.mmeUeS1apId(), "")).append(",");
        b.append(Objects.toString(body.enodebUeSiapId(), "")).append(",");
        return b.toString();
    }

    public static String decodePlmnId(byte[] plmnId) {
        if (plmnId == null || plmnId.length != 3) {
            return "Invalid";
        }

        int mcc1 = plmnId[0] & 0x0F;
        int mcc2 = (plmnId[0] >> 4) & 0x0F;
        int mcc3 = plmnId[1] & 0x0F;

        int mnc3 = (plmnId[1] >> 4) & 0x0F;
        int mnc1 = plmnId[2] & 0x0F;
        int mnc2 = (plmnId[2] >> 4) & 0x0F;

        StringBuilder plmn = new StringBuilder();
        plmn.append(mcc1).append(mcc2).append(mcc3);

        if (mnc3 == 0xF) {
            // Two-digit MNC
            plmn.append(mnc1).append(mnc2);
        } else {
            // Three-digit MNC
            plmn.append(mnc3).append(mnc1).append(mnc2);
        }

        return plmn.toString();
    }


    private void appendLocationInfo(StringBuilder b, int locationInfoPresent, Integer shapeType,
                                    HuaweiChrEventFile.TUndefinedInfo tUndefinedInfo,
                                    HuaweiChrEventFile.TEllipsoidPointInfo tEllipsoidPointInfo,
                                    HuaweiChrEventFile.TEllipsoidPointWithAltitudeInfo tEllipsoidPointWithAltitudeInfo,
                                    HuaweiChrEventFile.TEllipsoidPointWithUncertaintyCircleInfo tEllipsoidPointWithUncertaintyCircleInfo,
                                    HuaweiChrEventFile.TEllipsoidPointWithUncertaintyEllipseInfo tEllipsoidPointWithUncertaintyEllipseInfo,
                                    HuaweiChrEventFile.TEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo
                                            tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo) {

        b.append(Objects.toString(locationInfoPresent, "")).append(",");
        b.append(Objects.toString(shapeType, "")).append(",");

        UserLocation userLocation = null;

        if (locationInfoPresent == 1) {
            if (shapeType == 0) {
                userLocation = new UserLocation(tUndefinedInfo.degreesLatitude(),
                        tUndefinedInfo.degreesLongitude(),
                        tUndefinedInfo.latitudeSign(),
                        tUndefinedInfo.degreesAltitude(),
                        tUndefinedInfo.altitudeSign());
            } else if (shapeType == 1) {
                userLocation = new UserLocation(tEllipsoidPointInfo.degreesLatitude(),
                        tEllipsoidPointInfo.degreesLongitude(),
                        tEllipsoidPointInfo.latitudeSign());
            } else if (shapeType == 2) {
                userLocation = new UserLocation(tEllipsoidPointWithAltitudeInfo.degreesLatitude(),
                        tEllipsoidPointWithAltitudeInfo.degreesLongitude(),
                        tEllipsoidPointWithAltitudeInfo.latitudeSign(),
                        tEllipsoidPointWithAltitudeInfo.altitude(),
                        tEllipsoidPointWithAltitudeInfo.altitudeDirection());
            } else if (shapeType == 3) {
                userLocation = new UserLocation(tEllipsoidPointWithUncertaintyCircleInfo.degreesLatitude(),
                        tEllipsoidPointWithUncertaintyCircleInfo.degreesLongitude(),
                        tEllipsoidPointWithUncertaintyCircleInfo.latitudeSign());
            } else if (shapeType == 4) {
                userLocation = new UserLocation(tEllipsoidPointWithUncertaintyEllipseInfo.degreesLatitude(),
                        tEllipsoidPointWithUncertaintyEllipseInfo.degreesLongitude(),
                        tEllipsoidPointWithUncertaintyEllipseInfo.latitudeSign());
            } else if (shapeType == 5) {
                userLocation = new UserLocation(tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.degreesLatitude(),
                        tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.degreesLongitude(),
                        tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.latitudeSign(),
                        tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.altitude(),
                        tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.altitudeDirection());
            }
        }

        if (userLocation == null) {
            b.append(",,,,");

        } else {
            float userLat = ConversionHelper.convertLatitude(userLocation.getDegreesLatitude(), userLocation.getLatitudeSign());
            float userLon = ConversionHelper.convertLongitude(userLocation.getDegreesLongitude());
            float userAlt = 0;
            if (!userLocation.isEmpty()) {
                userAlt = userLocation.getAltitude() * (userLocation.getAltitudeDirection() == 0 ? 1 : -1);
            }

            String geoHash = ConversionHelper.generateGeoHash(userLat, userLon);

            b.append(Objects.toString(userLat, "")).append(",");
            b.append(Objects.toString(userLon, "")).append(",");
            b.append(userLocation.isEmpty() ? "" : userAlt).append(",");
            b.append(geoHash).append(",");
        }

        if (Objects.equals(tUndefinedInfo, null)) {
            b.append(",,,,,,");
        } else {
            b.append(Objects.toString(tUndefinedInfo.latitudeSign(), "")).append(",");
            b.append(Objects.toString(tUndefinedInfo.degreesLatitude(), "")).append(",");
            b.append(Objects.toString(tUndefinedInfo.degreesLongitude(), "")).append(",");
            b.append(Objects.toString(tUndefinedInfo.altitudeSign(), "")).append(",");
            b.append(Objects.toString(tUndefinedInfo.degreesAltitude(), "")).append(",");
            b.append(Objects.toString(tUndefinedInfo.uncertaintyCycle(), "")).append(",");
        }
        if (Objects.equals(tEllipsoidPointInfo, null)) {
            b.append(",,,");
        } else {
            b.append(Objects.toString(tEllipsoidPointInfo.latitudeSign(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointInfo.degreesLatitude(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointInfo.degreesLongitude(), "")).append(",");
        }

        if (tEllipsoidPointWithAltitudeInfo == null) {
            b.append(",,,,,");
        } else {
            b.append(Objects.toString(tEllipsoidPointWithAltitudeInfo.latitudeSign(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudeInfo.degreesLatitude(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudeInfo.degreesLongitude(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudeInfo.altitudeDirection(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudeInfo.altitude(), "")).append(",");
        }

        if (tEllipsoidPointWithUncertaintyCircleInfo == null) {
            b.append(",,,,");
        } else {
            b.append(Objects.toString(tEllipsoidPointWithUncertaintyCircleInfo.latitudeSign(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithUncertaintyCircleInfo.degreesLatitude(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithUncertaintyCircleInfo.degreesLongitude(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithUncertaintyCircleInfo.uncertainty(), "")).append(",");
        }

        if (tEllipsoidPointWithUncertaintyEllipseInfo == null) {
            b.append(",,,,,,,");
        } else {
            b.append(Objects.toString(tEllipsoidPointWithUncertaintyEllipseInfo.latitudeSign(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithUncertaintyEllipseInfo.degreesLatitude(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithUncertaintyEllipseInfo.degreesLongitude(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithUncertaintyEllipseInfo.uncertaintySemiMajor(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithUncertaintyEllipseInfo.uncertaintySemiMinor(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithUncertaintyEllipseInfo.orientationMajorAxis(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithUncertaintyEllipseInfo.confidence(), "")).append(",");
        }

        if (tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo == null) {
            b.append(",,,,,,,,,,");
        } else {
            b.append(Objects.toString(tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.latitudeSign(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.degreesLatitude(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.degreesLongitude(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.altitudeDirection(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.altitude(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.uncertaintySemiMajor(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.uncertaintySemiMinor(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.orientationMajorAxis(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.uncertaintyAltitude(), "")).append(",");
            b.append(Objects.toString(tEllipsoidPointWithAltitudAndUncertaintyEllipsoidInfo.confidence(), "")).append(",");
        }

    }

    private void appendDateAndSeviceCellIdAndCallId(StringBuilder
                                                            b, HuaweiEventsReducer.Tuple<HuaweiChrEventFile.TEventRecord, Long, Long, Long> eventTuple, ZoneId timeZoneId) {
        LocalDateTime time = (ConversionHelper.convertTimestampToDateTimeOfZone(eventTuple.timeStamp, timeZoneId));
        long servCellId = eventTuple.servCellId;
        long callId = eventTuple.callId;

        b.append(time == null ? "" : time.format(ConversionHelper.HUAWEI_DATETIME_FORMATTER)).append(",");// Datetime
        b.append(Objects.toString(servCellId, "")).append(",");
        b.append(Objects.toString(callId, "")).append(",");
    }

    private void appendCdma2000Info(StringBuilder b, int cdma2000CarrierFrequencyCount, ArrayList<HuaweiChrEventFile.TCdma2000CarrierInfo> cdma2000CarrierFrequencyList) {
        for (int i = 0; i < MAX_CDMA2000_CARRIERS; i++) {
            if (i < cdma2000CarrierFrequencyCount) {
                b.append(Objects.toString(cdma2000CarrierFrequencyList.get(i).arfcn(), "")).append(",");
                b.append(Objects.toString(cdma2000CarrierFrequencyList.get(i).bandClass(), "")).append(",");

                int cellCount = cdma2000CarrierFrequencyList.get(i).ncellCount();
                b.append(Objects.toString(cellCount, "")).append(",");

                for (int j = 0; j < MAX_NCELLS_PER_CARRIER; j++) {
                    if (j < cellCount) {
                        b.append(Objects.toString(cdma2000CarrierFrequencyList.get(i).ncellInfoList().get(j).pci(), "")).append(",");
                        b.append(Objects.toString(cdma2000CarrierFrequencyList.get(i).ncellInfoList().get(j).pilotPnPhase(), "")).append(",");
                        b.append(Objects.toString(cdma2000CarrierFrequencyList.get(i).ncellInfoList().get(j).pilotStrength(), "")).append(",");
                    } else {
                        b.append(",,,");
                    }
                }
            } else {
                b.append(",,,");
                b.append(",,,".repeat(MAX_NCELLS_PER_CARRIER));
            }
        }
    }

    private void appendGeranCellInfo(StringBuilder b, int geranNcellCount, ArrayList<HuaweiChrEventFile.TGeranNcellInfo> tGeranNcellInfos) {
        for (int i = 0; i < geranNcellCount; i++) {
            b.append(Objects.toString(tGeranNcellInfos.get(i).networkColourCode(), "")).append(",");
            b.append(Objects.toString(tGeranNcellInfos.get(i).baseStateColourCode(), "")).append(",");
            b.append(Objects.toString(tGeranNcellInfos.get(i).arfcn(), "")).append(",");
            b.append(Objects.toString(tGeranNcellInfos.get(i).bindIndicator(), "")).append(",");
            b.append(Objects.toString(tGeranNcellInfos.get(i).rssi(), "")).append(",");
        }

        b.append(",,,,,".repeat(Math.max(0, MAX_GERAN_CELL_COUNT - geranNcellCount)));
    }

    private void appendUtranInfo(StringBuilder b, int utranCarrierFrequencyCount, ArrayList<HuaweiChrEventFile.TUtranCarrierInfo> utranCarrierFrequencyList) {
        for (int i = 0; i < MAX_UTRAN_CARRIERS; i++) {
            if (i < utranCarrierFrequencyCount) {
                b.append(Objects.toString(utranCarrierFrequencyList.get(i).dlArfcn(), "")).append(",");

                int cellCount = utranCarrierFrequencyList.get(i).ncellCount();
                b.append(Objects.toString(cellCount, "")).append(",");

                for (int j = 0; j < MAX_NCELLS_PER_CARRIER; j++) {
                    if (j < cellCount) {
                        b.append(Objects.toString(utranCarrierFrequencyList.get(i).ncellInfoList().get(j).pci(), "")).append(",");
                        b.append(Objects.toString(utranCarrierFrequencyList.get(i).ncellInfoList().get(j).rscp(), "")).append(",");
                        b.append(Objects.toString(utranCarrierFrequencyList.get(i).ncellInfoList().get(j).ecNo(), "")).append(",");
                    } else {
                        b.append(",,,");
                    }
                }
            } else {
                b.append(",,");
                b.append(",,,".repeat(MAX_NCELLS_PER_CARRIER));
            }
        }
    }

    private void appendEutranInfo(StringBuilder b, int eutranCarrierFrequencyCount, ArrayList<HuaweiChrEventFile.TEutranCarrierInfo> eutranCarrierFrequencyList) {
        for (int i = 0; i < MAX_EUTRAN_CARRIERS; i++) {
            if (i < eutranCarrierFrequencyCount) {
                b.append(Objects.toString(eutranCarrierFrequencyList.get(i).arfcn(), "")).append(",");

                int cellCount = eutranCarrierFrequencyList.get(i).ncellCount();
                b.append(Objects.toString(cellCount, "")).append(",");

                for (int j = 0; j < MAX_NCELLS_PER_CARRIER; j++) {
                    if (j < cellCount) {
                        b.append(Objects.toString(eutranCarrierFrequencyList.get(i).ncellInfoList().get(j).pci(), "")).append(",");
                        b.append(Objects.toString(eutranCarrierFrequencyList.get(i).ncellInfoList().get(j).rsrp(), "")).append(",");
                        b.append(Objects.toString(eutranCarrierFrequencyList.get(i).ncellInfoList().get(j).rsrq(), "")).append(",");
                    } else {
                        b.append(",,,");
                    }
                }
            } else {
                b.append(",,");
                b.append(",,,".repeat(MAX_NCELLS_PER_CARRIER));
            }
        }
    }

    private void appendEutran100CInfo(StringBuilder b, int eutranCarrierFrequencyCount, ArrayList<HuaweiChrEventFile.TEutranCarrierInfo100c> eutranCarrierFrequencyList) {
        for (int i = 0; i < MAX_EUTRAN_CARRIERS; i++) {
            if (i < eutranCarrierFrequencyCount) {
                b.append(Objects.toString(eutranCarrierFrequencyList.get(i).arfcn(), "")).append(",");

                int cellCount = eutranCarrierFrequencyList.get(i).ncellCount();
                b.append(Objects.toString(cellCount, "")).append(",");

                for (int j = 0; j < MAX_NCELLS_PER_CARRIER; j++) {
                    if (j < cellCount) {
                        b.append(Objects.toString(eutranCarrierFrequencyList.get(i).ncellInfoList().get(j).pci(), "")).append(",");
                        b.append(Objects.toString(eutranCarrierFrequencyList.get(i).ncellInfoList().get(j).rsrp(), "")).append(",");
                        b.append(Objects.toString(eutranCarrierFrequencyList.get(i).ncellInfoList().get(j).rsrq(), "")).append(",");
                    } else {
                        b.append(",,,");
                    }
                }
            } else {
                b.append(",,");
                b.append(",,,".repeat(MAX_NCELLS_PER_CARRIER));
            }
        }
    }

    private void appendPreviousPcellInfo(StringBuilder b, HuaweiChrEventFile.TPreviousPcellInfo tPreviousPcellInfo) {
        if (Objects.equals(tPreviousPcellInfo.plmn(), null)) {
            b.append(",,");
        }
        {
            b.append(Objects.toString(tPreviousPcellInfo.plmn().plmnIdReserved(), "")).append(",");
            b.append(Objects.toString(decodePlmnId(tPreviousPcellInfo.plmn().plmnId()), "")).append(",");
//            b.append(Objects.toString(tPreviousPcellInfo.plmn().plmnId(), "")).append(",");
        }
        b.append(Objects.toString(tPreviousPcellInfo.cellId(), "")).append(",");
    }

    private void appendReEstablishmentCellInfo(StringBuilder b, HuaweiChrEventFile.TReEstablishmentCellInfo tReEstablishmentCellInfo) {
        if (Objects.equals(tReEstablishmentCellInfo.plmn(), null)) {
            b.append(",,");
        } else {
            b.append(Objects.toString(tReEstablishmentCellInfo.plmn().plmnIdReserved(), "")).append(",");
            b.append(Objects.toString(decodePlmnId(tReEstablishmentCellInfo.plmn().plmnId()), "")).append(",");
        }
        b.append(Objects.toString(tReEstablishmentCellInfo.cellId(), "")).append(",");
    }

    private void appendFailedPcellInfo(StringBuilder b, HuaweiChrEventFile.TFailedPcellInfo tFailedPcellInfo) {
        b.append(Objects.toString(tFailedPcellInfo.cellType(), "")).append(",");

        if (Objects.equals(tFailedPcellInfo.globalCellIdInfo(), null)) {
            b.append(",,,");
        } else {
            b.append(Objects.toString(tFailedPcellInfo.globalCellIdInfo().plmn().plmnIdReserved(), "")).append(",");
            b.append(Objects.toString(decodePlmnId(tFailedPcellInfo.globalCellIdInfo().plmn().plmnId()), "")).append(",");
//            b.append(Objects.toString(tFailedPcellInfo.globalCellIdInfo().plmn().plmnId(), "")).append(",");
            b.append(Objects.toString(tFailedPcellInfo.globalCellIdInfo().cellId(), "")).append(",");
        }
        if (Objects.equals(tFailedPcellInfo.pciArfcnInfo(), null)) {
            b.append(",,");
        } else {
            b.append(Objects.toString(tFailedPcellInfo.pciArfcnInfo().pci(), "")).append(",");
            b.append(Objects.toString(tFailedPcellInfo.pciArfcnInfo().carrierFrequency(), "")).append(",");
        }
    }

    private void appendFailedPcellInfo100C(StringBuilder b, HuaweiChrEventFile.TFailedPcellInfo100c tFailedPcellInfo) {
        b.append(Objects.toString(tFailedPcellInfo.cellType(), "")).append(",");

        if (tFailedPcellInfo.cellType() == 1) {
            b.append(Objects.toString(tFailedPcellInfo.globalCellIdInfo().plmn().plmnIdReserved(), "")).append(",");
            b.append(Objects.toString(decodePlmnId(tFailedPcellInfo.globalCellIdInfo().plmn().plmnId()), "")).append(",");
            b.append(Objects.toString(tFailedPcellInfo.globalCellIdInfo().cellId(), "")).append(",");
            b.append(",,");
        } else if (tFailedPcellInfo.cellType() == 2) {
            b.append(",,,");
            b.append(Objects.toString(tFailedPcellInfo.pciArfcnInfo().pci(), "")).append(",");
            b.append(Objects.toString(tFailedPcellInfo.pciArfcnInfo().carrierFrequency(), "")).append(",");
        }
    }

    private void appendUlPdcpDelayResult(StringBuilder b, int qciCount, ArrayList<HuaweiChrEventFile.TUlPdcpDelayResult> tUlPdcpDelayResults) {
        for (int i = 0; i < qciCount; i++) {
            b.append(Objects.toString(tUlPdcpDelayResults.get(i).qciId(), "")).append(",");
            b.append(Objects.toString(tUlPdcpDelayResults.get(i).excessDelay(), "")).append(",");
        }

        b.append(",,".repeat(Math.max(0, MAX_QCI_M6_UL_MDT - qciCount)));
    }

    private void appendPacketLossInfo(StringBuilder b, int qciCount, ArrayList<HuaweiChrEventFile.TPacketLossInfo> tPacketLossInfos) {
        for (int i = 0; i < qciCount; i++) {
            if (Objects.equals(tPacketLossInfos.get(i), null)) {
                b.append(",,,,,,");
            } else {
                b.append(Objects.toString(tPacketLossInfos.get(i).qci(), "")).append(",");
                b.append(Objects.toString(tPacketLossInfos.get(i).dlPacketTotal(), "")).append(",");
                b.append(Objects.toString(tPacketLossInfos.get(i).dlUuPacketLoss(), "")).append(",");
                b.append(Objects.toString(tPacketLossInfos.get(i).dlPdcpPacketLoss(), "")).append(",");
                b.append(Objects.toString(tPacketLossInfos.get(i).ulPacketTotal(), "")).append(",");
                b.append(Objects.toString(tPacketLossInfos.get(i).ulPacketLoss(), "")).append(",");
            }
        }

        b.append(",,,,,,".repeat(Math.max(0, MAX_QCI_M7_MDT - qciCount)));
    }
}
