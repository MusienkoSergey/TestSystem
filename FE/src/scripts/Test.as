import flash.events.Event;

import mx.events.ItemClickEvent;
import mx.rpc.events.ResultEvent;
import mx.controls.Alert;

import spark.components.RadioButton;

[Bindable]
public var question:String;

private function initApp():void {
    startButton.addEventListener(MouseEvent.CLICK, start);
    rAnswer.addEventListener(ItemClickEvent.ITEM_CLICK, handleAnswer);
}

private function handleAnswer(event:ItemClickEvent):void {
    QuestionService.getNextQuestion(event.currentTarget.selectedValue);
}

public function start(event:Event):void {
    QuestionService.startTest();
}

public function ResultdoQuestion(event:ResultEvent):void {
    rebuildQuestion(event.result);
    myGroupQuestion.visible = true;
}

public function rebuildQuestion(obj:Object):void {
    if (obj == null) {
        myGroupQuestion.visible = false;
        QuestionService.getResult();
    }
    myGroupAnswer.removeAllElements();
    question = obj.question;
    obj = obj.answers;
    for each (var p:Object in obj) {
        var myButton:RadioButton = new RadioButton();
        myButton.label = p.answer.toString();
        myButton.value = p.answerId;
        myButton.groupName = "rAnswer";
        myGroupAnswer.addElement(myButton);
    }
}

public function ResultdoNextQuestion(event:ResultEvent):void {
    rebuildQuestion(event.result);
}

public function ResultDoResult(event:ResultEvent):void {
    Alert.show(event.result.toString());
}