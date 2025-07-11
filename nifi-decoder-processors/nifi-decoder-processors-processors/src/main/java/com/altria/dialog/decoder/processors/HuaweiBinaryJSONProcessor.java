/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.altria.dialog.decoder.processors;

import com.altria.dialog.decoders.common.DecoderBase;
import com.altria.dialog.decoders.common.DecoderInput;
import com.altria.dialog.decoders.common.DecoderOutput;
import com.altria.dialog.decoders.common.OutputChannel;
import com.altria.dialog.decoders.ericsson.Ericsson2JsonDecoder;
import com.altria.dialog.decoders.huawei.Huawei2JsonDecoder;
import org.apache.nifi.components.PropertyDescriptor;
import org.apache.nifi.flowfile.FlowFile;
import org.apache.nifi.annotation.behavior.ReadsAttribute;
import org.apache.nifi.annotation.behavior.ReadsAttributes;
import org.apache.nifi.annotation.behavior.WritesAttribute;
import org.apache.nifi.annotation.behavior.WritesAttributes;
import org.apache.nifi.annotation.lifecycle.OnScheduled;
import org.apache.nifi.annotation.documentation.CapabilityDescription;
import org.apache.nifi.annotation.documentation.SeeAlso;
import org.apache.nifi.annotation.documentation.Tags;
import org.apache.nifi.flowfile.attributes.CoreAttributes;
import org.apache.nifi.flowfile.attributes.FragmentAttributes;
import org.apache.nifi.processor.exception.ProcessException;
import org.apache.nifi.processor.AbstractProcessor;
import org.apache.nifi.processor.ProcessContext;
import org.apache.nifi.processor.ProcessSession;
import org.apache.nifi.processor.ProcessorInitializationContext;
import org.apache.nifi.processor.Relationship;
import org.apache.nifi.processor.io.InputStreamCallback;
import org.apache.nifi.processor.util.StandardValidators;
import org.apache.nifi.stream.io.StreamUtils;
import org.apache.nifi.util.StopWatch;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Tags({"Huawei", "Binary", "JSON"})
@CapabilityDescription("Converts Huawei binary stream to JSON format")
@SeeAlso({ HuaweiBinaryCSVMergeProcessor.class, EricssonBinaryJSONProcessor.class, EricssonBinaryCSVMergeProcessor.class })
public class HuaweiBinaryJSONProcessor extends AbstractBinaryProcessorBase {

//    @Override
//    protected DecoderInput buildDecoderInput(byte[] bytes, OutputStream os, String inputFileName, String outputFileName) {
//        final DecoderInput decoderInput = new DecoderInput(bytes, 1,1)
//                .addChannel(new OutputChannel(Huawei2JsonDecoder.ALL_CHANNEL, os));
//        return decoderInput;
//    }

    @Override
    protected DecoderBase buildDecoder() {
        final Huawei2JsonDecoder decoder = new Huawei2JsonDecoder();
        return decoder;
    }

//    @Override
//    protected String getOutChannelName() {
//        return Huawei2JsonDecoder.ALL_CHANNEL;
//    }

    @Override
    protected String getOutFileName(String inputFileName, String suffix) {
        return inputFileName + "_" + suffix + ".json";
    }

    @Override
    protected DecoderInput buildDecoderMultiInput(byte[] inputBytes, Map<String, ByteArrayOutputStream> channelOutputStreams, String inputFileName, String suffix) {
        return null;
    }

    @Override
    protected String getChannelFileName(String inputFileName, String channelId, String suffix) {
        return "";
    }
}
