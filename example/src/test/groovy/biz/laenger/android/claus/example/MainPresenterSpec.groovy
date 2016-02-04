package biz.laenger.android.claus.example

import spock.lang.Specification

class MainPresenterSpec extends Specification {

    MainView mockView
    MainPresenter presenter

    def setup() {
        mockView = Mock(MainView)
        presenter = new MainPresenter()
        presenter.onViewCreated(mockView)
    }

    def "should set initial text"() {
        when:
        presenter.onViewCreated(mockView)

        then:
        1 * mockView.showText("button clicked 0 times")
    }

    def "should count button click events and update text"() {
        when:
        presenter.onButtonClicked()

        then:
        1 * mockView.showText("button clicked 1 times")

        when:
        20.times {
            presenter.onButtonClicked()
        }

        then:
        19 * mockView.showText(_)

        then:
        1 * mockView.showText("button clicked 21 times")
    }

}
